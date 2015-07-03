package com.haifei.ui;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 通知栏
 * @author Administrator
 *
 */
public class NotificationActivity extends Activity {

	private static int MOOD_NOTIFICATIONS = 999;
	private NotificationManager mNotificationManager;

	@android.webkit.JavascriptInterface
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LinearLayout root = new LinearLayout(this);
		setContentView(root);

		Button btn1 = new Button(this);
		btn1.setText("显示");
		btn1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setMood( getString(R.string.hello_world));

			}
		});
		root.addView(btn1);
		Button btn2 = new Button(this);
		btn2.setText("更新");
		btn2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setMood("更新成功");

			}
		});
		root.addView(btn2);
		Button btn3 = new Button(this);
		btn3.setText("取消");
		btn3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mNotificationManager.cancel(MOOD_NOTIFICATIONS);

			}
		});
		root.addView(btn3);
		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

	}

	private void setMood(String text) {
		// In this sample, we'll use the same text for the ticker and the
		// expanded notification
		//CharSequence text = getText(textId);

		// choose the ticker text
		String tickerText = "ticker" + text;

		// Set the icon, scrolling text and timestamp
		Notification notification = new Notification(R.drawable.ic_launcher, tickerText,
				System.currentTimeMillis());
		// new Notification.Builder(this).addAction(icon, title, intent)
		// Set the info for the views that show in the notification panel.
		notification.setLatestEventInfo(this, getText(R.string.app_name), text,
				makeMoodIntent());

		// Send the notification.
		// We use a layout id because it is a unique number. We use it later to
		// cancel.
		mNotificationManager.notify(MOOD_NOTIFICATIONS, notification);
	}

	private PendingIntent makeMoodIntent() {
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				new Intent(),
				PendingIntent.FLAG_UPDATE_CURRENT);
		return contentIntent;
	}

}