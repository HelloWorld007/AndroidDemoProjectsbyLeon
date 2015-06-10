package org.crazyit.cfg.changecfg;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ChangeCfg extends Activity {
	
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Configuration config = getResources().getConfiguration();
				// �����ǰ�Ǻ���
				if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
				{
					// ��Ϊ����
					ChangeCfg.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				};
				// �����ǰ������
				if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
				{
					// ��Ϊ����
					ChangeCfg.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"������Ļ":"������Ļ";
		Toast.makeText(this, "ϵͳ����Ļ�������ı�" + "\n�޸ĺ����Ļ����Ϊ:" + screen, Toast.LENGTH_LONG).show();
	}
}
