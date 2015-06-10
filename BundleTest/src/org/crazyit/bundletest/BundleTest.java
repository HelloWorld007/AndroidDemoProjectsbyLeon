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
				String gender = male.isChecked() ? "��" : "Ů";
				Person p = new Person(name.getText().toString(), password
						.getText().toString(), gender);
				// ����һ��Bundle���󣬲�����Serializable("person", p)
				// ��Person��������Bundle�У�Ȼ����ʹ��Intent����Я����
				// ���Bundle
				Bundle data = new Bundle();
				data.putSerializable("person", p);
				// ����һ��Intent
				Intent intent = new Intent(BundleTest.this,
						ResultActivity.class);
				intent.putExtras(data);
				startActivity(intent);
			}
		});
	}
}
