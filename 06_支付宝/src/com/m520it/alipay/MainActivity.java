package com.m520it.alipay;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//1.start  2.bind
		Intent intent=new Intent(this,AlipayService.class);
		startService(intent);
	}


}
