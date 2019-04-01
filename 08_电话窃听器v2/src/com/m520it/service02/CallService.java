package com.m520it.service02;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class CallService extends Service {

	private MediaRecorder mRecorder;

	@Override
	public void onCreate() {
		super.onCreate();
		// 开始时刻监听用户电话状态 休闲(没有电话) 铃响 接通 挂断
		// 如果自己写代码去监听用户的状态 肯定是很复杂的操作 求系统
		// 系统服务 电话有关的服务 sevice manager...作为后缀
		TelephonyManager manger = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// events 就是要指定对哪些事件比较关心
		manger.listen(new PhoneStateListener() {

			private String mIncomingNumber="";
			private boolean mIsRecording;

			// incomingNumber 只有来电的时候才有值
			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				switch (state) {
				case TelephonyManager.CALL_STATE_IDLE:
					Log.v("520it", "休闲(没有电话)/挂断:" + incomingNumber);
					if (mRecorder!=null&&mIsRecording) {
						mRecorder.stop();
						mRecorder.release();
						mRecorder = null;
						mIsRecording=false;
					}
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:
					Log.v("520it", "接通 :" + incomingNumber);
					//MediaRecorder 录音
					mRecorder = new MediaRecorder();
					//设置音频的来源     MIC DEFAULT开发的时候
					//真实打电话  VOICE_DOWNLINK/VOICE_UPLINK      
					//VOICE_CALL既能听到自己的声音 也能听到别人的声音
					mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
					//录音之后要形成一个音频文件 音频的后缀是   .3gp   .mp3  .mp4
					mRecorder
							.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					//设置录音的文件保存到什么地方
					mRecorder.setOutputFile(getRecordFilePath(mIncomingNumber));
					//设置音频内部解码
					mRecorder
							.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
					try {
						mRecorder.prepare();
					} catch (IOException e) {

					}
					mRecorder.start();
					mIsRecording=true;
					break;
				case TelephonyManager.CALL_STATE_RINGING:
					Log.v("520it", "来电:" + incomingNumber);
					mIncomingNumber=incomingNumber;
					break;
				}

			}
		}, PhoneStateListener.LISTEN_CALL_STATE);

	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	/**
	 * 获取文件的路径
	 */
	private String getRecordFilePath(String phone){
		//文件名的格式    电话号码+"#"时间+".3gp"
		SimpleDateFormat formatter=new SimpleDateFormat("yy-MM-dd hh:mm");
		String fileName=phone+"#"+formatter.format(new Date())+".3gp";
		File file=new File(getFilesDir(),fileName);
		return file.getAbsolutePath();
	} 

}
