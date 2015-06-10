package org.crazyit.bundletest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class BundleTest extends Activity {

	EditText name;
	EditText password;
	RadioButton male;
	Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				name = (EditText) findViewById(R.id.name);
				password = (EditText) findViewById(R.id.password);
				male = (RadioButton) findViewById(R.id.male);
				String gender = male.isChecked() ? "男" : "女";
				Person p = new Person(name.getText().toString(), password
						.getText().toString(), gender);
				// 创建一个Bundle对象，并调用Serializable("person", p)
				// 将Person对象放入该Bundle中，然后再使用Intent来“携带”
				// 这个Bundle
				Bundle data = new Bundle();
				data.putSerializable("person", p);
				// 创建一个Intent
				Intent intent = new Intent(BundleTest.this,
						ResultActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}
}
