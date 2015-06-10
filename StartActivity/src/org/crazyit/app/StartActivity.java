package org.crazyit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartActivity extends Activity {
	
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		btn = (Button)findViewById(R.id.btn);
		
		btn.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View source)
			{
				Intent intent = new Intent(StartActivity.this, SecondActivity.class);
				
				startActivity(intent);
			}
		});
	}
}
