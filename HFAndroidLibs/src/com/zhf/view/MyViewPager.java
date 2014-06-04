package com.zhf.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyViewPager extends ViewPager {

	public MyViewPager(Context context) {
		super(context);
	}

	public MyViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
		
	}

	/**
	 * 用于解决 ListView /ScrollView 中addView（ViewPager）
	 * http://linkyan.com/2013/05/intercept-touchevent/
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		requestDisallowInterceptTouchEvent(true);
		return super.dispatchTouchEvent(ev);
	}
	

}
