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
		// ��ʼʱ�̼����û��绰״̬ ����(û�е绰) ���� ��ͨ �Ҷ�
		// ����Լ�д����ȥ�����û���״̬ �϶��Ǻܸ��ӵĲ��� ��ϵͳ
		// ϵͳ���� �绰�йصķ��� sevice manager...��Ϊ��׺
		TelephonyManager manger = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		// events ����Ҫָ������Щ�¼��ȽϹ���
		manger.listen(new PhoneStateListener() {

			private String mIncomingNumber="";
			private boolean mIsRecording;

			// incomingNumber ֻ�������ʱ�����ֵ
			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				switch (state) {
				case TelephonyManager.CALL_STATE_IDLE:
					Log.v("520it", "����(û�е绰)/�Ҷ�:" + incomingNumber);
					if (mRecorder!=null&&mIsRecording) {
						mRecorder.stop();
						mRecorder.release();
						mRecorder = null;
						mIsRecording=false;
					}
					break;
				case TelephonyManager.CALL_STATE_OFFHOOK:
					Log.v("520it", "��ͨ :" + incomingNumber);
					//MediaRecorder ¼��
					mRecorder = new MediaRecorder();
					//������Ƶ����Դ     MIC DEFAULT������ʱ��
					//��ʵ��绰  VOICE_DOWNLINK/VOICE_UPLINK      
					//VOICE_CALL���������Լ������� Ҳ���������˵�����
					mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
					//¼��֮��Ҫ�γ�һ����Ƶ�ļ� ��Ƶ�ĺ�׺��   .3gp   .mp3  .mp4
					mRecorder
							.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
					//����¼�����ļ����浽ʲô�ط�
					mRecorder.setOutputFile(getRecordFilePath(mIncomingNumber));
					//������Ƶ�ڲ�����
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
					Log.v("520it", "����:" + incomingNumber);
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
	 * ��ȡ�ļ���·��
	 */
	private String getRecordFilePath(String phone){
		//�ļ����ĸ�ʽ    �绰����+"#"ʱ��+".3gp"
		SimpleDateFormat formatter=new SimpleDateFormat("yy-MM-dd hh:mm");
		String fileName=phone+"#"+formatter.format(new Date())+".3gp";
		File file=new File(getFilesDir(),fileName);
		return file.getAbsolutePath();
	} 

}
