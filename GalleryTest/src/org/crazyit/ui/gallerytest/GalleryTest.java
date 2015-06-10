package org.crazyit.ui.gallerytest;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryTest extends Activity {
	
	/*
	 * Android�Ѿ������Ƽ�ʹ��Gallery����������Ƽ�ʹ������ˮƽ�������
	 * ��HorizontalScrollView��ViewPager������Gallery�����������°汾
	 * ��Androidƽ̨��Ӧ�þ�������Gallery���
	 * */
	
	Gallery gallery;
	ImageView imageView;
	
	int[] imageIds = new int[]
			{
				R.drawable.shuangzi, R.drawable.shuangyu,
				R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
				R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
				R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
				R.drawable.mojie
			};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		gallery = (Gallery)findViewById(R.id.gallery);
		// ��ȡ��ʾͼƬ��ImageView����
		BaseAdapter adapter = new BaseAdapter(){
			@Override
			public int getCount(){
				return imageIds.length;
			}
			@Override
			public Object getItem(int position)
			{
				return position;
			}
			@Override
			public long getItemId(int position){
				return position;
			}
			// �÷������ص�View������ÿ���б���
			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				// ����һ��ImageView
				ImageView imageView = new ImageView(GalleryTest.this);
				imageView.setImageResource(imageIds[position]);
				// ����ImageView����������
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				// ΪimageView���ò��ֲ���
				imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
				TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
				imageView.setBackgroundResource(typedArray.getResourcesId(R.styleable.Gallery_android_galleryItemBackground, 0));
				return imageView;
			}
		};
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener(){
			// ��Galleryѡ������ı�ʱ�����÷���

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				imageView.setImageResource(imageIds[position]);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
			}
		});
	}
}
