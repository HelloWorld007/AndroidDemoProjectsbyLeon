package org.crazyit.ui.eventqs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EventQs extends Activity {
	
	private Button bn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		bn = (Button)findViewById(R.id.bn);
		// Ϊ��ť���¼�������
		bn.setOnClickListener(new MyClickListener());
	}
	
	// ����һ�������¼��ļ�����
	class MyClickListener implements View.OnClickListener
	{
		// ʵ�ּ����������ʵ�ֵķ������÷���������Ϊ�¼�������
		@Override
		public void onClick(View v){
			EditText txt = (EditText)findViewById(R.id.txt);
			txt.setText("bn��������");
		}
	}
}
