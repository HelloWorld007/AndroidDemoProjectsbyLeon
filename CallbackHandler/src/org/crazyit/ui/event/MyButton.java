package org.crazyit.ui.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Button;

public class MyButton extends Button {
	
	public MyButton(Context context, AttributeSet set){
		super(context, set);
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		super.onKeyDown(keyCode, event);
		Log.v("-crazy.org-", "the onKeyDown in MyButton");
		// ����true���������¼�����������ɢ
		//	return true;
		// ����false��������δ��ȫ�������¼������¼���Ȼ������ɢ
		 return false;
	}
}