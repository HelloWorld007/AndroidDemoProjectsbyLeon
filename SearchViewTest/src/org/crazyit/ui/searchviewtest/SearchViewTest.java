package org.crazyit.ui.searchviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class SearchViewTest extends Activity implements SearchView.OnQueryTextListener{

	private SearchView sv;
	private ListView lv;
	// �Զ���ɵ��б�
	private final String[] mStrings = {"aaaaa", "bbbbb", "cccccc"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		lv = (ListView)findViewById(R.id.lv);
		lv.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, mStrings));
		lv.setTextFilterEnabled(true);
		sv = (SearchView)findViewById(R.id.sv);
		// ���ø�searchViewĬ���Ƿ��Զ���СΪͼ��
		sv.setIconifiedByDefault(false);
		// Ϊ��SearchView��������¼�������
		sv.setOnQueryTextListener(this);
		// ���ø�SearchView��ʾ������ť
		sv.setSubmitButtonEnabled(true);
		// ���ø�SearchView��Ĭ����ʾ����ʾ�ı�
		sv.setQueryHint("����");
	}

	// �û������ַ�ʱ�����÷���
	@Override
	public boolean onQueryTextChange(String newText) 
	{
		if(TextUtils.isEmpty(newText)){
			// ���ListView�Ĺ���
			lv.clearTextFilter();
		}else{
			// ʹ���û���������ݶ�ListView���б�����й���
			lv.setFilterText(newText);
		}
		return true;
	}
	
	// ����������ťʱ�����÷���
	@Override
	public boolean onQueryTextSubmit(String query) {
		
		// ʵ��Ӧ����Ӧ���ڸ÷�����ִ��ʵ�ʲ�ѯ
		// �˴���ʹ��Toast��ʾ�û�����Ĳ�ѯ����
		Toast.makeText(this, "����ѡ����:" + query, Toast.LENGTH_SHORT).show();
		return false;
	}

}
