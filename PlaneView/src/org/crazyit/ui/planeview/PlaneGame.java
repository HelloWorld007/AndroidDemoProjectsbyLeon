package org.crazyit.ui.planeview;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.view.WindowManager;

public class PlaneGame extends Activity {
	// ����ɻ����ƶ��ٶ�
	private int speed = 10;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		// ȥ�����ڱ���
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		// ȫ����ʾ
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// ����PlaneView���
		final PlaneView planeView = new PlaneView(this);
		setContentView(planeView);
		planeView.setBackgroundResource(R.drawable.background);
		// ��ȡ���ڹ�����
		WindowManager windowManager = getWindowManager();
		Display display = windowManager.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		// ��ȡ��Ļ��͸�
		display.getMetrics(metrics);
		// ���÷ɻ���ʼλ��
		planeView.currentX = metrics.widthPixels / 2;
		planeView.currentY = metrics.heightPixels - 40;
		// Ϊdraw��������¼��󶨼�����
		planeView.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View source, int keyCode, KeyEvent event){
				// ��ȡ���ĸ����������¼�
				switch(event.getKeyCode()){
				// ���Ʒɻ�����
				case KeyEvent.KEYCODE_S:
					planeView.currentY += speed;
				// ���Ʒɻ�����
				case KeyEvent.KEYCODE_W:
					planeView.currentY -= speed;
					break;
				case KeyEvent.KEYCODE_A:
					planeView.currentX -= speed;
					break;
				case KeyEvent.KEYCODE_D:
					planeView.currentX += speed;
					break;
				}
				// ֪ͨplaneView����ػ�
				planeView.invalidate();
				return true;
			}
		});
		
	}

}
