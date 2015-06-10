package org.crazyit.ui.seekbartest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class SeekBarTest extends Activity {
	
	ImageView image;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		image = (ImageView)findViewById(R.id.image);
		SeekBar seekBar = (SeekBar)findViewById(R.id.seekbar);
		seekBar.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			// 当拖动的滑块位置发生改变时出发该方法
			@Override
			public void onProgressChanged(SeekBar arg0, int progress, boolean fromUser)
			{
				// 动态改变图片的透明度
				image.setAlpha(progress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
