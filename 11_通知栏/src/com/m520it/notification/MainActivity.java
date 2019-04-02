package com.m520it.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void showNotificationBy2(View v) {
		// 1.获取系统服务
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// notification 由2部分组成
		// when 什么时候提示该消息
		Notification notification = new Notification(R.drawable.ic_launcher,
				"音乐播放器:xxxx", System.currentTimeMillis());
		// contentIntent 点击通知栏的时候决定要跳转的意图
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT 如果界面已经启动了 就不要再启动
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "音乐播放器", "xxxx音乐正在播放...",
				pendingIntent);
		// id 来标示当前的提示
		// notification 封装了提示的内容
		manager.notify(0, notification);
	}

	public void dismissNotification(View v) {
		// 1.获取系统服务
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.取消带有某个id的通知栏
		// manager.cancel(id)
		manager.cancelAll();
	}

	public void showNotificationBy4(View v) {
		// 1.获取系统服务
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.创建Notification
		Notification notification = new Notification();
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = "播放音乐:xxxx";
		notification.when = System.currentTimeMillis();
		// contentIntent 点击通知栏的时候决定要跳转的意图
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT 如果界面已经启动了 就不要再启动
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "音乐播放器", "xxxx音乐正在播放...",
				pendingIntent);
//		notification.contentView
		manager.notify(0, notification);
	}

}
