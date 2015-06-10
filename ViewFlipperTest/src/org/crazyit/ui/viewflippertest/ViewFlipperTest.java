package org.crazyit.ui.viewflippertest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class ViewFlipperTest extends Activity {

	private ViewFlipper viewFlipper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		viewFlipper = (ViewFlipper)findViewById(R.id.details);
	}
	public void prev(View source){
		viewFlipper.setInAnimation(this, R.anim.slide_in_right);
		viewFlipper.setOutAnimation(this, R.anim.slide_out_left);
		// ��ʾ��һ�����
		viewFlipper.showPrevious();
		// ֹͣ�Զ�����
		viewFlipper.stopFlipping();
	}
	public void next(View source){
		viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
		viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
		// ��ʼ�Զ�����
		viewFlipper.startFlipping();
	}
	
}
