package org.crazyit.io.adapterviewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class AdapterViewFlipperTest extends Activity {

	int[] imageIds = new int[]
			{
				R.drawable.shuangzi, R.drawable.shuangyu,
				R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
				R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
				R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
				R.drawable.mojie
			};
	
	AdapterViewFlipper flipper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
		// ����һ��BaseAdapter���󣬸ö������ṩGallery����ʾ���б���
		BaseAdapter adapter = new BaseAdapter(){
			@Override
			public int getCount(){
				return imageIds.length;
			}

			@Override
			public Object getItem(int position) {
				return position;
			}

			@Override
			public long getItemId(int position) {
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				// ����һ��ImageView
				ImageView imageView = new ImageView(AdapterViewFlipperTest.this);
				imageView.setImageResource(imageIds[position]);
				// ����ImageView����������
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				// ΪimageView���ò��ֲ���
				imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				return imageView;
			}
		};
		flipper.setAdapter(adapter);
	}
	public void prev(View source)
	{
		// ��ʾ��һ�����
		flipper.showPrevious();
		// ֹͣ�Զ�����
		flipper.stopFlipping();
	}
	public void next(View source)
	{
		// ��ʾ��һ�����
		flipper.showNext();
		// ֹͣ�Զ�����
		flipper.stopFlipping();
	}
	public void auto(View source)
	{
		// ��ʼ�Զ�����
		flipper.startFlipping();
	}
}
