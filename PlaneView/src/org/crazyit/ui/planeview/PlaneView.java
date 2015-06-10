package org.crazyit.ui.planeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class PlaneView extends View {
	
	public float currentX;
	public float currentY;
	Bitmap plane;
	public PlaneView(Context context)
	{
		super(context);
		// ����ɻ�ͼƬ
		plane = BitmapFactory.decodeResource(context.getResources(), R.drawable.plane);
		setFocusable(true);
	}

	@Override
	public void onDraw(Canvas canvas){
		super.onDraw(canvas);
		// ��������
		Paint p = new Paint();
		// ���Ʒɻ�
		canvas.drawBitmap(plane, currentX, currentY, p);
	}
}
