package org.crazyit.handler.calprime;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalPrimer extends Activity {
	
	static final String UPPER_NUM = "upper";
	EditText etNum;
	CalThread calThread;
	
	// ����һ���߳���
	class CalThread extends Thread
	{
		public Handler mHandler;
		public void run()
		{
			Looper.prepare();
			mHandler = new Handler()
			{
				// ���崦����Ϣ�ķ���
				@Override
				public void handleMessage(Message msg)
				{
					if(msg.what == 0x123)
					{
						int upper = msg.getData().getInt(UPPER_NUM);
						List<Integer> nums = new ArrayList<Integer>();
						// ����2��ʼ����upper����������
						outer:
							for(int i = 2; i<=upper; i++)
							{
								// ��i����2��ʼ����i��ƽ������������
								for(int j = 2; j <= Math.sqrt(i);j++)
								{
									if(i != 2 && i % j == 0)  continue outer;
									nums.add(i);
								}
							}
						// ʹ��Toast��ʾͳ�Ƴ������е�����
						Toast.makeText(CalPrimer.this, nums.toString(), Toast.LENGTH_LONG).show();
					}
				}
			};
			Looper.loop();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		etNum = (EditText)findViewById(R.id.etNum);
		calThread = new CalThread();
		// �������߳�
		calThread.start();
	}

	// Ϊ��ť�ĵ���¼��ṩ�¼�������
	public void cal(View source)
	{
		// ������Ϣ
		Message msg = new Message();
		msg.what = 0x123;
		Bundle bundle = new Bundle();
		bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
		msg.setData(bundle);
		// �����߳��е�Handler������Ϣ
		calThread.mHandler.sendMessage(msg);
	}
}
