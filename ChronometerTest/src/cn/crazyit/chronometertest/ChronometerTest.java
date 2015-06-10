package cn.crazyit.chronometertest;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Chronometer.OnChronometerTickListener;

import com.example.chronometertest.R;


public class ChronometerTest extends Activity {

	Chronometer ch;
	Button start;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// 获取计时器组件
		ch = (Chronometer)findViewById(R.id.start);
		// 获取"开始"按钮
		start = (Button)findViewById(R.id.start);
		start.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View source){
				// 设置开始时间
				ch.setBase(SystemClock.elapsedRealtime());
				ch.start();
				start.setEnabled(false);
			}
		});
		
		// 为Chronometer绑定监听事件
		ch.setOnChronometerTickListener(new OnChronometerTickListener(){
			@Override
			public void onChronometerTick(Chronometer ch){
				// 如果从开始计时到现在超过了20s
				if(SystemClock.elapsedRealtime() - ch.getBase() > 20 * 1000)
				{
					ch.stop();
					start.setEnabled(true);
				}
			}
		});
	}
}
