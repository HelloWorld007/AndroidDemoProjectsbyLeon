package org.crazyit.ui.calendarviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import android.widget.Toast;

public class CalendarViewTest extends Activity {
	
	CalendarView cv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		cv = (CalendarView)findViewById(R.id.calendarView);
		
		// ΪCalendarView��������ڸı��¼�����¼�������
		cv.setOnDateChangeListener(new OnDateChangeListener(){

			@Override
			public void onSelectedDayChange(CalendarView view, int year,
					int month, int dayOfMonth) {
				// ʹ��Toast��ʾ�û�ѡ�������
				Toast.makeText(CalendarViewTest.this, "���������" + 
				year + "��" + month + "��"
				+ dayOfMonth + "��", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
