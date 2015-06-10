package org.crazyit.handler.handlertest;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

public class HandlerTest extends Activity {


	
	// ������������ʾͼƬ��ID
	int[] imageIds = new int[]
	{
			R.drawable.java,
			R.drawable.ee,
			R.drawable.ajax,
			R.drawable.xml,
			R.drawable.classic
	};
	
	int currentImageId = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final ImageView show = (ImageView)findViewById(R.id.show);
		final Handler myHandler = new Handler()
		{
			@Override
			public void handleMessage(Message msg)
			{
				// �������Ϣ�Ǳ������͵�
				if(msg.what == 0x123)
				{
					// ��̬���޸�����ʾ��ͼƬ
					show.setImageResource(imageIds[currentImageId++%imageIds.length]);
				}
			}
		};
		
		// ����һ����ʱ�����øü�ʱ�������Ե�ִ��ָ������
		new Timer().schedule(new TimerTask(){
			@Override
			public void run()
			{
				// ���Ϳ���Ϣ
				myHandler.sendEmptyMessage(0x123);
			}
		}, 0, 100);
	}
}
