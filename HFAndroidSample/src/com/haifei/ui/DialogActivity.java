package com.haifei.ui;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * JAVA 与 html通过javascript 相互调用的例子
 * 
 * @author: Haifei
 * @data：2014-3-25
 * @blog:http://blog.csdn.net/hellohaifei
 * 
 */
public class DialogActivity extends Activity {

	@android.webkit.JavascriptInterface
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout root = new LinearLayout(this);
		setContentView(root);
		
		Button btn1 = new Button(this);
		btn1.setText("自定义对话框");
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
			}
		});
	}

}