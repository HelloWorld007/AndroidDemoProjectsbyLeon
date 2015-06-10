package org.crazyit.ui.expandablelistviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ExpandableListViewTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// ����һ��BaseExpandableListAdapter����
		ExpandableListAdapter adapter = new BaseExpandableListAdapter(){
			int[] logos = new int[]
					{
					R.drawable.p,
					R.drawable.z,
					R.drawable.t
					};
			
			private String[] armTypes = new String[]{"�������", "�������", "�������"};
			private String[][] arms = new String[][]
					{
					{"��սʿ", "����ʿ", "�ڰ�ʥ��", "���"},
					{"С��", "����", "����", "�Ա��ɻ�"},
					{"��ǹ��", "��ʿMM", "����"}
					};
			
			// ��ȡָ����λ�á�ָ�����б�������б�������
			@Override
			public Object getChild(int groupPosition, int childPosition) {
				return arms[groupPosition][childPosition];
			}

			@Override
			public long getChildId(int groupPosition, int childPosition) {
				return childPosition;
			}

			// �÷��������ض��������������б��������
			@Override
			public int getChildrenCount(int groupPosition) {
				return arms[groupPosition].length;
			}
			
			private TextView getTextView(){
				AbsListView.LayoutParams lp = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 64);
				TextView textView = new TextView(ExpandableListViewTest.this);
				textView.setLayoutParams(lp);
				textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
				textView.setPadding(36, 0, 0, 0);
				textView.setTextSize(20);
				return textView;
			}
			
			// ��ȡָ��λ�ô���������
			@Override
			public Object getGroup(int groupPosition){
				return armTypes[groupPosition];
			}
			
			// �÷������ذ��������б��������
			@Override
			public int getGroupCount(){
				return armTypes.length;
			}
			@Override
			public long getGroupId(int groupPosition){
				return groupPosition;
			}
			
			// �÷�������ÿ����������
			// �÷������ص�View������Ϊ���б���
			@Override
			public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent){
				LinearLayout ll = new LinearLayout(ExpandableListViewTest.this);
				ll.setOrientation(0);
				ImageView logo = new ImageView(ExpandableListViewTest.this);
				logo.setImageResource(logos[groupPosition]);
				ll.addView(logo);
				TextView textView = getTextView();
				textView.setText(getGroup(groupPosition).toString());
				ll.addView(textView);
				return ll;
			}
			@Override
			public boolean isChildSelectable(int groupPosition, int childPosition)
			{
				return true;
			}
			@Override
			public boolean hasStableIds()
			{
				return true;
			}

			// �÷������ص�View����Ϊ�ض��顢�ض�λ�õ����б���
			@Override
			public View getChildView(int groupPosition, int childPosition,
					boolean isLastChild, View convertView, ViewGroup parent) {
				return null;
			}
		};
		ExpandableListView expandListView = (ExpandableListView)findViewById(R.id.list);
		expandListView.setAdapter(adapter);
	}
}
