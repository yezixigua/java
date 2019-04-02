package com.m520it.musicplayer;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MusicAdapter extends BaseAdapter {

	private ArrayList<String> mDatas;

	public void setDatas(ArrayList<String> mMusicFilePath) {
		mDatas = mMusicFilePath;
	}

	@Override
	public int getCount() {
		return mDatas != null ? mDatas.size() : 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView tv=null;
		if (convertView == null) {
			convertView = LayoutInflater.from(parent.getContext()).inflate(
					android.R.layout.simple_list_item_1, null);
			tv = (TextView) convertView.findViewById(android.R.id.text1);
			convertView.setTag(tv);
		}else {
			tv=(TextView) convertView.getTag();
		}
		String fileName = getFileName(mDatas.get(position));
		tv.setText(fileName);
		return convertView;
	}
	
	private String getFileName(String filePath){
		return filePath.substring(filePath.lastIndexOf("/")+1);
	}

	@Override
	public Object getItem(int position) {
		return mDatas!=null?mDatas.get(position):null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

}
