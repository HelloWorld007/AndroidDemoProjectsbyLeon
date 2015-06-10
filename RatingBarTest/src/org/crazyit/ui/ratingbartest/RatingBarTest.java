package org.crazyit.ui.ratingbartest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;

public class RatingBarTest extends Activity {
	
	RatingBar ratingBar;
	ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ratingBar = (RatingBar)findViewById(R.id.rating);
		imageView = (ImageView)findViewById(R.id.imageView);
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener(){
			// 当拖动的滑块位置发生改变时触发该方法
			@Override
			public void onRatingChanged(RatingBar arg0, float rating, boolean fromUser){
				// 动态改变图片的透明度，其中255是星级评分条的最大值
				// 5个星星就代表最大值255
				imageView.setAlpha((int)(rating*255/5));
			}
		});
	}
}
