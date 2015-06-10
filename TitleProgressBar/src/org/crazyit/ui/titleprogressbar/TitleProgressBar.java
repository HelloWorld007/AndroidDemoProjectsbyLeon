package org.crazyit.ui.titleprogressbar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class TitleProgressBar extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 设置窗口特征：启用显示进度的进度条
		requestWindowFeature(Window.FEATURE_PROGRESS);
		// 设置窗口特征：启用不显示进度的进度条
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.main);
		Button bn1 = (Button)findViewById(R.id.bn1);
		Button bn2 = (Button)findViewById(R.id.bn2);
		bn1.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View source) {
				// 显示不带进度的进度条
				setProgressBarIndeterminateVisibility(true);
				// 显示带进度的进度条
				setProgressBarVisibility(true);
				// 设置进度条的进度
				setProgress(4500);
			}
		});
		bn2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View source) {
				// 隐藏不带进度的进度条
				setProgressBarIndeterminateVisibility(false);
				// 隐藏带进度的进度条
				setProgressBarVisibility(false);
			}
		});
	}
}
