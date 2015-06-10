package org.crazyit.ui.tabhosttest;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabHostTest extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ��ȡ��Activity�����TabHost���
		TabHost tabHost = getTabHost();
		// ������һ��Tabҳ
		TabSpec tab1 = tabHost.newTabSpec("tab1")
				.setIndicator("�ѽӵ绰")	// ���ñ���
				.setContent(R.id.tab01);	// ��������
		// ���ӵ�һ����ǩҳ
		tabHost.addTab(tab1);
		TabSpec tab2 = tabHost.newTabSpec("tab2")
				// �ڱ�ǩ���Ϸ���ͼ��
				.setIndicator("�����绰", getResources()
				.getDrawable(R.drawable.ic_launcher))
				.setContent(R.id.tab02);
		// ���ӵڶ�����ǩҳ
		tabHost.addTab(tab2);
		TabSpec tab3 = tabHost.newTabSpec("tab3")
				.setIndicator("δ�ӵ绰")
				.setContent(R.id.tab03);
		// ���ӵ�������ǩҳ
		tabHost.addTab(tab3);
	}
}