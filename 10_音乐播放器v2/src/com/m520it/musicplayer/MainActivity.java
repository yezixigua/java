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
		//1.初始化UI
		initUI();
		//2.初始化数据-->SD卡里面来的
		initData();
		//3.将数据设置到adapter
		mMusicAdapter.setDatas(mMusicFilePath);
		mMusicAdapter.notifyDataSetChanged();
		//4.启动绑定服务
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
		//5.设置播放的模式    1.播完停止   2.单曲循环  3.全部循环
	}

	private void initData() {
		mMusicFilePath=new ArrayList<String>();
		//1.应该找到SD卡的路径
		File sdCardFile = Environment.getExternalStorageDirectory();
		//2.循环遍历子文件
		File[] listFiles = sdCardFile.listFiles();
		for (File file : listFiles) {
			//3.判断文件是否以mp3结尾
			String absolutePath = file.getAbsolutePath();
			if (absolutePath.endsWith("mp3")) {
				//4.如果是的话 则需要将路径添加到mMusicFilePath队列里面去
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
		//TODO  拿到代理对象 
		mMusicervice.callPlayMusic(mMusicFilePath,position);
	}
	
	//创建菜单栏  返回true 代表告诉系统 我们自己处理 不需要系统插手
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	//菜单栏按钮被点击的时候回调的方法
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
				//退出应用
				//1.通知栏要去掉 并且释放播放器的资源(要跟服务打交道)
				mMusicervice.callStopMusicService();
				//2.服务要停止
				unbindService(mServiceConnection);
				Intent intent=new Intent(this,MusicService.class);
				stopService(intent);
				//3.界面要退出
				finish();
				break;
		}
		edit.commit();
		return true;
	}


}
