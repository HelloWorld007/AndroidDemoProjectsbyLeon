package org.crazyit.cfg.configurationtest;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ConfigurationTest extends Activity {
	
	private EditText orientation;
	private EditText navigation;
	private EditText touch;
	private EditText mnc;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ȡӦ�ý����еĽ������
		orientation = (EditText)findViewById(R.id.orientation);
		navigation = (EditText)findViewById(R.id.navigation);
		touch = (EditText)findViewById(R.id.touch);
		mnc = (EditText)findViewById(R.id.mnc);
		btn = (Button)findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// ��ȡϵͳ��Configuration����
				Configuration cfg = getResources().getConfiguration();
				String screen = cfg.orientation == Configuration.ORIENTATION_LANDSCAPE?"������Ļ":"������Ļ";
				String mncCode = cfg.mnc + "";
				String naviName = cfg.orientation == Configuration.NAVIGATION_NONAV
						?"û�з������":
						cfg.orientation == Configuration.NAVIGATION_WHEEL
						?"���ֿ��Ʒ���":
						cfg.orientation == Configuration.NAVIGATION_DPAD
						?"��������Ʒ���":"�켣����Ʒ���";
				navigation.setText(naviName);
				String touchName = cfg.touchscreen ==
						Configuration.TOUCHSCREEN_NOTOUCH
						?"�޴�����":"֧�ִ�����";
				orientation.setText(screen);
				mnc.setText(mncCode);
				touch.setText(touchName);
			}
		});
		
	}
}
