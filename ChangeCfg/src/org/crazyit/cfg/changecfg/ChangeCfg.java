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
				// 如果当前是横屏
				if(config.orientation == Configuration.ORIENTATION_LANDSCAPE)
				{
					// 设为竖屏
					ChangeCfg.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				};
				// 如果当前是竖屏
				if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
				{
					// 设为横屏
					ChangeCfg.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
	}
	
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		String screen = newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE?"横向屏幕":"竖向屏幕";
		Toast.makeText(this, "系统的屏幕方向发生改变" + "\n修改后的屏幕方向为:" + screen, Toast.LENGTH_LONG).show();
	}
}
