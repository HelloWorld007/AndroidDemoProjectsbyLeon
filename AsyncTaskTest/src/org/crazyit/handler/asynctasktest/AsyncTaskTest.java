package org.crazyit.handler.asynctasktest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskTest extends Activity {
	
	private TextView show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (TextView)findViewById(R.id.show);
	}
	
	// ��д�÷�����Ϊ����İ�ť�ṩ�¼���Ӧ����
	public void download(View source) throws MalformedURLException
	{
		DownTask task = new DownTask(this);
		task.execute(new URL("http://www.crazyit.org/ethos.php"));
	}
	
	class DownTask extends AsyncTask<URL, Integer, String>
	{
		// �ɱ䳤�������������AsyncTask.execute()��Ӧ
		ProgressDialog pdialog;
		// �����¼�Ѿ���ȡ�е�����
		int hasRead = 0;
		Context mContext;
		public DownTask(Context ctx)
		{
			mContext = ctx;
		}
		@Override
		protected String doInBackground(URL...params)
		{
			StringBuilder sb = new StringBuilder();
			try{
				URLConnection conn = params[0].openConnection();
				// ��conn���Ӷ�Ӧ������������������װ��BufferedReader
				BufferedReader br = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "utf-8"));
				String line = null;
				while((line=br.readLine())!=null)
				{
					sb.append(line+"\n");
					hasRead++;
					publishProgress(hasRead);
				}
				return sb.toString();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
		}
		@Override
		protected void onPostExecute(String result)
		{
			// ����HTMLҳ�������
			show.setText(result);
			pdialog.dismiss();
		}
		@Override
		protected void onPreExecute()
		{
			pdialog = new ProgressDialog(mContext);
			// ���öԻ���ı���
			pdialog.setTitle("��������ִ����");
			// ���öԻ�����ʾ������
			pdialog.setMessage("�������ڽ����У�����ȴ�����");
			// ���öԻ�������"ȡ����ť"�ر�
			pdialog.setCancelable(false);
			// ���øý�������������ֵ
			pdialog.setMax(202);
			// ���öԻ���Ľ��������
			pdialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// ���öԻ���Ľ������Ƿ���ʾ����
			pdialog.setIndeterminate(false);
			pdialog.show();
		}
		@Override
		protected void onProgressUpdate(Integer...values)
		{
			// ���½���
			show.setText("�Ѿ���ȡ�ˡ�" + values[0] + "����");
			pdialog.setProgress(values[0]);
		}
	}
}
