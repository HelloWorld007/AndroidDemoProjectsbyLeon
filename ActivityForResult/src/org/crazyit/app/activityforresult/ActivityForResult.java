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
		// ��requestCode��resultCodeͬʱΪ0ʱ��Ҳ���Ǵ����ض��Ľ��
		if(requestCode == 0 && resultCode == 0)
		{
			// ȡ��Intent���Extra����
			Bundle data = intent.getExtras();
			// ȡ��Bundle�е�����
			String resultCity = data.getString("city");
			// �޸�city�ı��������
			city.setText(resultCity);
		}
	}
}
