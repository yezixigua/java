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
		// 1.��ȡϵͳ����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// notification ��2�������
		// when ʲôʱ����ʾ����Ϣ
		Notification notification = new Notification(R.drawable.ic_launcher,
				"���ֲ�����:xxxx", System.currentTimeMillis());
		// contentIntent ���֪ͨ����ʱ�����Ҫ��ת����ͼ
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT ��������Ѿ������� �Ͳ�Ҫ������
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "���ֲ�����", "xxxx�������ڲ���...",
				pendingIntent);
		// id ����ʾ��ǰ����ʾ
		// notification ��װ����ʾ������
		manager.notify(0, notification);
	}

	public void dismissNotification(View v) {
		// 1.��ȡϵͳ����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.ȡ������ĳ��id��֪ͨ��
		// manager.cancel(id)
		manager.cancelAll();
	}

	public void showNotificationBy4(View v) {
		// 1.��ȡϵͳ����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.����Notification
		Notification notification = new Notification();
		notification.icon = R.drawable.ic_launcher;
		notification.tickerText = "��������:xxxx";
		notification.when = System.currentTimeMillis();
		// contentIntent ���֪ͨ����ʱ�����Ҫ��ת����ͼ
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT ��������Ѿ������� �Ͳ�Ҫ������
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "���ֲ�����", "xxxx�������ڲ���...",
				pendingIntent);
//		notification.contentView
		manager.notify(0, notification);
	}

}
