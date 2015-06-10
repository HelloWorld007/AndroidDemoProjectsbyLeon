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
			// ���϶��Ļ���λ�÷����ı�ʱ�����÷���
			@Override
			public void onRatingChanged(RatingBar arg0, float rating, boolean fromUser){
				// ��̬�ı�ͼƬ��͸���ȣ�����255���Ǽ������������ֵ
				// 5�����Ǿʹ������ֵ255
				imageView.setAlpha((int)(rating*255/5));
			}
		});
	}
}
