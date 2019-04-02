package com.m520it.taobao;

import com.m520it.alipay.IAlipayService;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ServiceConnection mServiceConnection;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void payClick(View v) {
		Intent intent = new Intent();
		intent.setAction("com.m520it.alipay.action.SAFEPAY");
		mServiceConnection = new ServiceConnection() {

			@Override
			public void onServiceDisconnected(ComponentName name) {

			}

			// 在该方法中返回代理 IAlipayService
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				// 如何将IBinder对象转换成IAlipayService
				IAlipayService alipayService = IAlipayService.Stub
						.asInterface(service);
				// 调用支付的业务
				/**
				 * 	代码出错了---- -1
				 *  支付密码错误---1 
				 *  余额不足----2 
				 *  支付成功----3
				 */
				try {
					int payResult = alipayService.callSafePay("zhangsan", "123", "123456",
							1200d, System.currentTimeMillis());
					switch (payResult) {
						case 0:
							Toast.makeText(MainActivity.this, "账号密码错误", 0).show();
							break;
						case 1:
							Toast.makeText(MainActivity.this, "支付密码错误", 0).show();
							break;
						case 2:
							Toast.makeText(MainActivity.this, "余额不足", 0).show();
							break;
						case 3:
							Toast.makeText(MainActivity.this, "支付成功", 0).show();
							break;
					}
				} catch (RemoteException e) {
					e.printStackTrace();
				}

			}
		};
		bindService(intent, mServiceConnection, BIND_AUTO_CREATE);
	}

}
