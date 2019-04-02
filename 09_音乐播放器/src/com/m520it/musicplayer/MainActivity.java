package com.m520it.musicplayer;

import java.io.File;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView mMusicLv;
	private MusicAdapter mMusicAdapter;
	private ArrayList<String> mMusicFilePath;

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
	}


}
