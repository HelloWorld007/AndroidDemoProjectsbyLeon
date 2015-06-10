package org.crazyit.app.activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityForResult extends Activity {
	
	Button btn;
	EditText city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		btn = (Button)findViewById(R.id.btn);
		city = (EditText)findViewById(R.id.city);
		
		btn.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ActivityForResult.this,
						SelectCityActivity.class);
				startActivityForResult(intent, 0);
			}
		});
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent)
	{
		// 当requestCode、resultCode同时为0时，也就是处理特定的结果
		if(requestCode == 0 && resultCode == 0)
		{
			// 取出Intent里的Extra数据
			Bundle data = intent.getExtras();
			// 取出Bundle中的数据
			String resultCity = data.getString("city");
			// 修改city文本框的内容
			city.setText(resultCity);
		}
	}
}
