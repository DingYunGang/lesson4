package com.example.lesson4;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class DActivity extends Activity {

	
	ViewPager vp_showg;
	
	//要显示的视图的集合
	List<View> views = new ArrayList<View>();
	
	
	int[] girls = {
		R.drawable.s1,
		R.drawable.s2,
		R.drawable.s3,
		R.drawable.s4,		
	};
	
	
	//初始化视图
	public void initViews(){
		
		for(int i=0; i<girls.length; i++){
			
			//图片框
			ImageView iv = new ImageView(this);
			//设置图片框中的图片的编号
			iv.setImageResource(girls[i]);
			
			
			views.add(iv);
			
		}
		
	}
	
	//内部类
	//编写控制器Controller，控制器本身也是一个对象，我们需要编写一个控制类
	public class MyController extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 10000;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			
			position = position % 4;
			
			View view = views.get(position);
			container.addView(view);
			return view;
			
			
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			
			position = position % 4;
			View view = views.get(position);
			container.removeView(view);
		}
		
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_d);
		
		//将mvc整合在一起
	
		//View
		vp_showg = (ViewPager) findViewById(R.id.vp_showgirl);
	
		//Model
		initViews();
		
		//控制器
		MyController con = new MyController();
		
	
		//设置视图的控制器是con
		vp_showg.setAdapter(con);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}