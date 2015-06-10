package org.crazyit.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Lifecycle extends Activity {
	
	final String TAG = "--CrazyId--";
	Button finish, startActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		//  ‰≥ˆ»’÷æ
		Log.d(TAG, "-------onCreate-------");
		finish = (Button)findViewById(R.id.finish);
		startActivity = (Button)findViewById(R.id.startActivity);
		
		startActivity.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View source)
			{
				Intent intent = new Intent(Lifecycle.this, SecondActivity.class);
				startActivity(intent);
			}
		});
		
		finish.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View source)
			{
				Lifecycle.this.finish();
			}
		});
	}
	@Override
	public void onStart()
	{
		super.onStart();
		Log.d(TAG, "-------onStart-------");
	}
	@Override
	public void onRestart()
	{
		super.onRestart();
		Log.d(TAG, "-------onRestart-------");
	}
	@Override
	public void onResume()
	{
		super.onResume();
		Log.d(TAG, "-------onResume-------");
	}
	@Override
	public void onPause()
	{
		super.onPause();
		Log.d(TAG, "-------onPause-------");
	}
	@Override
	public void onStop()
	{
		super.onStop();
		Log.d(TAG, "-------onStop-------");
	}
	@Override
	public void onDestroy()
	{
		super.onDestroy();
		Log.d(TAG, "-------onDestroy-------");
	}
}
