package org.crazyit.ui.activitylistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityListener extends Activity implements OnClickListener {

	EditText show;
	Button bn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		show = (EditText)findViewById(R.id.show);
		bn = (Button)findViewById(R.id.bn);
		// 直接使用Activity作为事件监听器
		bn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		show.setText("bn按钮被单击了!");
	}
}
