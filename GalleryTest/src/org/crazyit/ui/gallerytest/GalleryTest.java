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
	 * Android已经不在推荐使用Gallery组件，而是推荐使用其他水平滚动组件
	 * 如HorizontalScrollView和ViewPager来代替Gallery组件。因此在新版本
	 * 的Android平台上应该尽量少用Gallery组件
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
		// 获取显示图片的ImageView对象
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
			// 该方法返回的View代表了每个列表项
			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				// 创建一个ImageView
				ImageView imageView = new ImageView(GalleryTest.this);
				imageView.setImageResource(imageIds[position]);
				// 设置ImageView的缩放类型
				imageView.setScaleType(ImageView.ScaleType.FIT_XY);
				// 为imageView设置布局参数
				imageView.setLayoutParams(new Gallery.LayoutParams(75, 100));
				TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
				imageView.setBackgroundResource(typedArray.getResourcesId(R.styleable.Gallery_android_galleryItemBackground, 0));
				return imageView;
			}
		};
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(new OnItemSelectedListener(){
			// 当Gallery选中项发生改变时触发该方法

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
