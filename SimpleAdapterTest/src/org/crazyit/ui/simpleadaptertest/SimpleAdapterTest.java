package org.crazyit.ui.simpleadaptertest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.crazyit.simpleadaptertest.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SimpleAdapterTest extends Activity {

	private String[] names = new String[]{"��ͷ", "Ū��", "������", "���"};
	private String[] descs = new String[]{"�ɰ���С��", "һ���ó����ֵ�Ů��", "һ���ó���ѧ��Ů��", "��������ʫ��"};
	private int[] imageIds = new int[]{R.drawable.tiger, R.drawable.nongyu, R.drawable.qingzhao, R.drawable.libai};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// ����һ��List���ϣ�List���ϵ�Ԫ����Map
		List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();
		for(int i = 0; i<names.length; i++){
			Map<String, Object> listItem = new HashMap<String, Object>();
			listItem.put("header", imageIds[i]);
			listItem.put("personName", names[i]);
			listItem.put("desc", descs[i]);
			listItems.add(listItem);
		}
		
		// ����һ��SimpleAdapter
		SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems, R.layout.simple_item, new String[]{"personName", "header", "desc"},
				new int[] {R.id.name, R.id.header, R.id.desc});
		ListView list = (ListView)findViewById(R.id.mylist);
		// ΪListView����Adapter
		list.setAdapter(simpleAdapter);
		list.setOnItemClickListener(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				System.out.println(names[position] + "��������");
			}
		});
		
		//ΪListView���б����ѡ���¼����¼�������
		list.setOnItemSelectedListener(new OnItemSelectedListener(){

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				System.out.println(names[position] + "��ѡ����");
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
}
