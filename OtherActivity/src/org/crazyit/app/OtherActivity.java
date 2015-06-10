package org.crazyit.app;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class OtherActivity extends LauncherActivity{
	
	// ��������Activity������
	String[] names = {"���ó������", "�鿴�Ǽ�����"};
	
	// ��������Activity��Ӧ��ʵ����
	Class<?>[] classes = {PreferenceActivityTest.class, 
			ExpandableListActivityTest.class};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				android.R.layout.simple_list_item_1, names);
		// ���øô�����ʾ���б������Adapter
		setListAdapter(adapter);
	}
	
	// �����б����ָ��Activity��Ӧ��Intent
	@Override public Intent intentForPosition(int position)
	{
		return new Intent(OtherActivity.this, classes[position]);
	}
}
