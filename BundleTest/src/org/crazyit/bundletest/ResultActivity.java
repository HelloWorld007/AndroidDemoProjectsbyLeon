package org.crazyit.bundletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends Activity {
	
	TextView name;
	TextView password;
	TextView gender;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		name = (TextView)findViewById(R.id.name);
		password = (TextView)findViewById(R.id.password);
		gender = (TextView)findViewById(R.id.gender);
		// ��ȡ��Result��Intent
		Intent intent = getIntent();
		// ֱ��ͨ��Intentȥ������Я����Bundle���ݰ��е�����
		Person p = (Person)intent.getSerializableExtra("person");
		name.setText("�����û���Ϊ: " + p.getName());
		password.setText("��������Ϊ: " + p.getPassword());
		gender.setText("�����Ա�Ϊ: " + p.getGender());
	}
}
