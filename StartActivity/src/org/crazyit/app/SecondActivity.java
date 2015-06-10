package org.crazyit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity {

	private Button btnPrevious;
	private Button btnClose;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);

		btnPrevious = (Button)findViewById(R.id.previous);
		btnClose = (Button)findViewById(R.id.close);
		
		btnPrevious.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View source)
			{
				Intent intent = new Intent(SecondActivity.this,
						StartActivity.class);
				startActivity(intent);
			}
		});
		
		btnClose.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View source)
			{
				Intent intent = new Intent(SecondActivity.this, StartActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}

}
