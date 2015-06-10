package org.crazyit.app;

import java.util.List;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.Toast;

public class PreferenceActivityTest extends PreferenceActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		// �÷�������Ϊ�ý�������һ�����ⰴť
		if(hasHeaders())
		{
			Button button = new Button(this);
			button.setText("���ò���");
			// ����ť��ӵ��ý�����
			setListFooter(button);
		}
	}
	
	// ��д�÷������������ҳ�沼���ļ�
	@Override
	public void onBuildHeaders(List<Header> target)
	{
		// ����ѡ�������б�Ĳ����ļ�
		loadHeadersFromResource(R.xml.preference_headers, target);
	}
	
	public static class Prefs1Fragment extends PreferenceFragment
	{
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.preferences);
		}
	}
	public static class Prefs2Fragment extends PreferenceFragment
	{
		@Override
		public void onCreate(Bundle savedInstanceState)
		{
			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.display_prefs);
			// ��ȡ�����Fragment�Ĳ���
			String website = getArguments().getString("website");
			Toast.makeText(getActivity(), 
					"��վ������: " + website, Toast.LENGTH_LONG).show();
		}
	}
}
