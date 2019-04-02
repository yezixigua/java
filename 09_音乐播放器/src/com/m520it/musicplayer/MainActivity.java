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
		//1.��ʼ��UI
		initUI();
		//2.��ʼ������-->SD����������
		initData();
		//3.���������õ�adapter
		mMusicAdapter.setDatas(mMusicFilePath);
		mMusicAdapter.notifyDataSetChanged();
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
	}


}
