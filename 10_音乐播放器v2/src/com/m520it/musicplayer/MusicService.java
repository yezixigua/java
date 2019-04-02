package com.m520it.musicplayer;

import java.util.ArrayList;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

	private MediaPlayer mMediaPlayer;

	@Override
	public IBinder onBind(Intent intent) {
		return new MusicAgent();
	}
	
	private class MusicAgent extends Binder implements IMusicService{

		@Override
		public void callPlayMusic(ArrayList<String> filePaths, int position) {
			playMusic(filePaths, position);
		}

		@Override
		public void callStopMusicService() {
			stopMusicService();
		}
		
	}
	
	int mCurrentPosition;
	
	/**
	 * �������ֵķ���
	 */
	public void playMusic(final ArrayList<String> filePaths,final int position) {
		mCurrentPosition=position;
		//һ�������־͸��û�һ��֪ͨ  Shift+Alt+M 
		showNotify(getFileName(filePaths, position));
		try {
			if (mMediaPlayer == null) {
				mMediaPlayer = new MediaPlayer();// IDLE����״̬
				mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
					//�����ֲ�����ɵ�ʱ�򱻵���  ���ݵ�ǰ�Ĳ���ģʽ�������ǵ���ѭ����������...
					@Override
					public void onCompletion(MediaPlayer mp) {
						SharedPreferences sp = getSharedPreferences("music", MODE_PRIVATE);
						int musicMode = sp.getInt("mode", 0);
						switch (musicMode) {
							case 1://����ѭ�� 
								playMusic(filePaths,mCurrentPosition);
								break;
							case 2://ȫ��ѭ��
								mCurrentPosition++;
								//��������� ��ʱ�������ڶ��е����һ������ ��Ҫ���0
								if (mCurrentPosition>filePaths.size()-1) {
									mCurrentPosition=0;
								}
								playMusic(filePaths,mCurrentPosition);
								break;
						}
					}
				});
			}
			//�����һ������������Դ�� �ٴν�����Ҫ�����ͷ���Դ
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(filePaths.get(mCurrentPosition));// ��������Դ
			mMediaPlayer.prepare();//׼������
			mMediaPlayer.start();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private String getFileName(final ArrayList<String> filePaths,
			final int position) {
		String filePath = filePaths.get(position);
		return filePath.substring(filePath.lastIndexOf("/")+1);
	}
	
	private void showNotify(String musicName) {
		// 1.��ȡϵͳ����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// notification ��2�������
		// when ʲôʱ����ʾ����Ϣ
		Notification notification = new Notification(R.drawable.ic_launcher,
				"���ֲ�����:"+musicName, System.currentTimeMillis());
		// contentIntent ���֪ͨ����ʱ�����Ҫ��ת����ͼ
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT ��������Ѿ������� �Ͳ�Ҫ������
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "���ֲ�����", musicName+"���ڲ���...",
				pendingIntent);
		// id ����ʾ��ǰ����ʾ
		// notification ��װ����ʾ������
		manager.notify(0, notification);
	}
	

	public void cancelNotify() {
		// 1.��ȡϵͳ����
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.ȡ������ĳ��id��֪ͨ��
		// manager.cancel(id)
		manager.cancelAll();
	}
	
	/**
	 * 	ֹͣ����
	 */
	public void stopMusicService(){
		//1.ȡ��֪ͨ��
		cancelNotify();
		//2.�ͷ�mMediaPlayer����Դ
		if (mMediaPlayer!=null) {
			mMediaPlayer.stop();
			mMediaPlayer.release();
			mMediaPlayer=null;
		}
	}

}
