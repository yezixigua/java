package com.m520it.musicplayer;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView mMusicLv;
	private MusicAdapter mMusicAdapter;
	private ArrayList<String> mMusicFilePath;
	private ServiceConnection mServiceConnection;
	private IMusicService mMusicervice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//1.��ʼ��UI
		initUI();
		//2.��ʼ������-->SD����������
		initData();
		//3.���������õ�adapter
		mMusicAdapter.setDatas(mMusicFilePath);
		mMusicAdapter.notifyDataSetChanged();
		//4.�����󶨷���
		Intent intent=new Intent(this,MusicService.class);
		startService(intent);
		mServiceConnection = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
				
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder binder) {
				mMusicervice=(IMusicService) binder;
			}
		};
		bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
		//5.���ò��ŵ�ģʽ    1.����ֹͣ   2.����ѭ��  3.ȫ��ѭ��
	}

	private void initData() {
		mMusicFilePath=new ArrayList<String>();
		//1.Ӧ���ҵ�SD����·��
		File sdCardFile = Environment.getExternalStorageDirectory();
		//2.ѭ���������ļ�
		File[] listFiles = sdCardFile.listFiles();
		for (File file : listFiles) {
			//3.�ж��ļ��Ƿ���mp3��β
			String absolutePath = file.getAbsolutePath();
			if (absolutePath.endsWith("mp3")) {
				//4.����ǵĻ� ����Ҫ��·����ӵ�mMusicFilePath��������ȥ
				mMusicFilePath.add(absolutePath);
			}
		}
	}

	private void initUI() {
		mMusicLv =(ListView) findViewById(R.id.music_lv);
		mMusicAdapter = new MusicAdapter();
		mMusicLv.setAdapter(mMusicAdapter);
		mMusicLv.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		//TODO  �õ�������� 
		mMusicervice.callPlayMusic(mMusicFilePath,position);
	}
	
	//�����˵���  ����true �������ϵͳ �����Լ����� ����Ҫϵͳ����
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//�˵�����ť�������ʱ��ص��ķ���
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		SharedPreferences sp = getSharedPreferences("music", MODE_PRIVATE);
		Editor edit = sp.edit();
		int itemId = item.getItemId();
		switch (itemId) {
			case R.id.stop_when_over:
				edit.putInt("mode", 0);
				break;
			case R.id.single_loop:
				edit.putInt("mode", 1);
				break;
			case R.id.all_loop:
				edit.putInt("mode", 2);
				break;
			case R.id.logout_app:
				//�˳�Ӧ��
				//1.֪ͨ��Ҫȥ�� �����ͷŲ���������Դ(Ҫ������򽻵�)
				mMusicervice.callStopMusicService();
				//2.����Ҫֹͣ
				unbindService(mServiceConnection);
				Intent intent=new Intent(this,MusicService.class);
				stopService(intent);
				//3.����Ҫ�˳�
				finish();
				break;
		}
		edit.commit();
		return true;
	}


}
