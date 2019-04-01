package com.m520it.service01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	
	public void startServiceClick(View v){
		//启动服务只能通过代码的形式来启动
		Intent intent=new Intent(this,MyService.class);
		startService(intent);
	}
	
	//虽然应用界面已经退出 但是服务还存在的
	//停止服务 可以通过按钮来关闭也可以通过代码
	public void stopServiceClick(View v){
		Intent intent=new Intent(this,MyService.class);
		stopService(intent);
	}

}
