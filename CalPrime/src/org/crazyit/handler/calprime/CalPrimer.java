package org.crazyit.handler.calprime;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CalPrimer extends Activity {
	
	static final String UPPER_NUM = "upper";
	EditText etNum;
	CalThread calThread;
	
	// 定义一个线程类
	class CalThread extends Thread
	{
		public Handler mHandler;
		public void run()
		{
			Looper.prepare();
			mHandler = new Handler()
			{
				// 定义处理消息的方法
				@Override
				public void handleMessage(Message msg)
				{
					if(msg.what == 0x123)
					{
						int upper = msg.getData().getInt(UPPER_NUM);
						List<Integer> nums = new ArrayList<Integer>();
						// 计算2开始、到upper的所有质数
						outer:
							for(int i = 2; i<=upper; i++)
							{
								// 用i除以2开始、到i的平方根的所有书
								for(int j = 2; j <= Math.sqrt(i);j++)
								{
									if(i != 2 && i % j == 0)  continue outer;
									nums.add(i);
								}
							}
						// 使用Toast显示统计出来所有的质数
						Toast.makeText(CalPrimer.this, nums.toString(), Toast.LENGTH_LONG).show();
					}
				}
			};
			Looper.loop();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		etNum = (EditText)findViewById(R.id.etNum);
		calThread = new CalThread();
		// 启动新线程
		calThread.start();
	}

	// 为按钮的点击事件提供事件处理函数
	public void cal(View source)
	{
		// 创建消息
		Message msg = new Message();
		msg.what = 0x123;
		Bundle bundle = new Bundle();
		bundle.putInt(UPPER_NUM, Integer.parseInt(etNum.getText().toString()));
		msg.setData(bundle);
		// 向新线程中的Handler发送消息
		calThread.mHandler.sendMessage(msg);
	}
}
