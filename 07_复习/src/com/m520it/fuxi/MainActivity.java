package com.m520it.fuxi;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		Uri 统一资源定位符(资源在哪个地方 应该有一个字符串来描述他)  
//		ftp://  http://  rtsp://
//		fromFile(file) 将一个文件作为资源定位
//		parse("http://dasda")  定位一个http的网络资源
		
//		Intent 可以传递8大基本类型 还可以传递对象
		Intent intent=new Intent();
//		Bundle对象 封装了8大基本类型  就是一个 HashMap
//		intent.putExtras(Bundle);
		
		
	}


}
