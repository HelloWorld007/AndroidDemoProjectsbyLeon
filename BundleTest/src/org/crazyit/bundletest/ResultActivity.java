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
		// 获取该Result的Intent
		Intent intent = getIntent();
		// 直接通过Intent去除它所携带的Bundle数据包中的数据
		Person p = (Person)intent.getSerializableExtra("person");
		name.setText("您的用户名为: " + p.getName());
		password.setText("您的密码为: " + p.getPassword());
		gender.setText("您的性别为: " + p.getGender());
	}
}
