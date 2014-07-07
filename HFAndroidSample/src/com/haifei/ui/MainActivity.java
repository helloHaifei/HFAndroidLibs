package com.haifei.ui;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	List<Custom> mList;
	{
		mList = new ArrayList<MainActivity.Custom>();
		mList.add(new Custom("JAVA与HTML相互调用", JavascriptInterface.class));
		mList.add(new Custom("TextViw样式", TextViewSpanActivity.class));
		mList.add(new Custom("自定义组件使用attr属性", CustomViewActivity.class));
		mList.add(new Custom("自定义对话框", DialogActivity.class));
	}

	
	@SuppressLint("JavascriptInterface")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
	}

	Intent intent = new Intent();
	void initView(){
		LinearLayout root = (LinearLayout) findViewById(R.id.main_linearlayout);
		
		for (Custom item :mList) {
			TextView tv = new TextView(this);
			tv.setTextSize(16);
			tv.setText(item.title);
			tv.setTag(item.activityClass);
			tv.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Class<?> activityClass = (Class<?>) v.getTag();
					intent.setClass(MainActivity.this,activityClass);
					startActivity(intent);
				}
			});
			
			root.addView(tv,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 50));
		}
	}
	
	class Custom{
		String title;
		Class<?> activityClass;
		public Custom(String title, Class<?> c) {
			this.title = title;
			this.activityClass = c;
		}
	}
}