package com.example.quickcontactbadgetest;

import android.app.Activity;
import android.os.Bundle;

public class QuickContactBadge extends Activity {

	QuickContactBadge badge;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ȡQuickContactBadge���
		badge = (QuickContactBadge)findViewById(R.id.badge);
		// ��QuickContactBadge������ض��绰�����Ӧ����ϵ�˽�������
		badge.assignContactFromPhone("020-88888888", false);
	}
}
