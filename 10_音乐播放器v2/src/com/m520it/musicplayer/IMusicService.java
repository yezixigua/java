package com.m520it.musicplayer;

import java.util.ArrayList;

public interface IMusicService {

	/**
	 * ��������
	 */
	public void callPlayMusic(final ArrayList<String> filePaths,final int position);
	
	/**
	 * �رշ��� �ͷ���Դ
	 */
	public void callStopMusicService();
	
}
