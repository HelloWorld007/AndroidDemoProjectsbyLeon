package org.crazyit.ui.dialogtheme;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DialogTheme extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button bn =(Button)findViewById(R.id.bn);
		// Ϊ��ť��ʱ�������
		bn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				// ������Activity
				finish();
			}
		});
	}
}
