package org.crazyit.ui.spinnertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SpinnerTest extends Activity {
	
	Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// ��ȡ���沼���ļ��е�Spinner���
		spinner = (Spinner)findViewById(R.id.spinner);
		String[] arr = {"�����", "��˽�", "��ɮ"};
		// ����ArrayAdapter����
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, arr);
		// ΪSpinner����Adapter
		spinner.setAdapter(adapter);
	}
}
