package com.m520it.musicplayer;

import java.util.ArrayList;

public interface IMusicService {

	/**
	 * 播放音乐
	 */
	public void callPlayMusic(final ArrayList<String> filePaths,final int position);
	
	/**
	 * 关闭服务 释放资源
	 */
	public void callStopMusicService();
	
}
