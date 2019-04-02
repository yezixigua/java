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
	 * 播放音乐的服务
	 */
	public void playMusic(final ArrayList<String> filePaths,final int position) {
		mCurrentPosition=position;
		//一播放音乐就给用户一个通知  Shift+Alt+M 
		showNotify(getFileName(filePaths, position));
		try {
			if (mMediaPlayer == null) {
				mMediaPlayer = new MediaPlayer();// IDLE空闲状态
				mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
					
					//当音乐播放完成的时候被调用  根据当前的播放模式来决定是单曲循环还是其他...
					@Override
					public void onCompletion(MediaPlayer mp) {
						SharedPreferences sp = getSharedPreferences("music", MODE_PRIVATE);
						int musicMode = sp.getInt("mode", 0);
						switch (musicMode) {
							case 1://单曲循环 
								playMusic(filePaths,mCurrentPosition);
								break;
							case 2://全部循环
								mCurrentPosition++;
								//如果加完了 此时索引大于队列的最后一个索引 就要变成0
								if (mCurrentPosition>filePaths.size()-1) {
									mCurrentPosition=0;
								}
								playMusic(filePaths,mCurrentPosition);
								break;
						}
					}
				});
			}
			//如果上一次有设置数据源了 再次进来需要重新释放资源
			mMediaPlayer.reset();
			mMediaPlayer.setDataSource(filePaths.get(mCurrentPosition));// 设置数据源
			mMediaPlayer.prepare();//准备数据
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
		// 1.获取系统服务
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// notification 由2部分组成
		// when 什么时候提示该消息
		Notification notification = new Notification(R.drawable.ic_launcher,
				"音乐播放器:"+musicName, System.currentTimeMillis());
		// contentIntent 点击通知栏的时候决定要跳转的意图
		Intent intent = new Intent(this, MainActivity.class);
		// PendingIntent.FLAG_ONE_SHOT 如果界面已经启动了 就不要再启动
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
				intent, PendingIntent.FLAG_ONE_SHOT);
		notification.setLatestEventInfo(this, "音乐播放器", musicName+"正在播放...",
				pendingIntent);
		// id 来标示当前的提示
		// notification 封装了提示的内容
		manager.notify(0, notification);
	}
	

	public void cancelNotify() {
		// 1.获取系统服务
		NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		// 2.取消带有某个id的通知栏
		// manager.cancel(id)
		manager.cancelAll();
	}
	
	/**
	 * 	停止服务
	 */
	public void stopMusicService(){
		//1.取消通知栏
		cancelNotify();
		//2.释放mMediaPlayer的资源
		if (mMediaPlayer!=null) {
			mMediaPlayer.stop();
			mMediaPlayer.release();
			mMediaPlayer=null;
		}
	}

}
