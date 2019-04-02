package com.m520it.alipay;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class AlipayService extends Service {
	
	public class MyAlipayAgent extends IAlipayService.Stub{

		@Override
		public int callSafePay(String account, String pwd, String payPwd,
				double money, long currTimeMiles) {
			return safePay(account,pwd,payPwd,money,currTimeMiles);
		}
		
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return new MyAlipayAgent();
	}

	/**
	 * @param account  账号
	 * @param pwd	密码
	 * @param payPwd	支付密码
	 * @param money	支付金额
	 * @param currTimeMiles 当前的时间戳
	 * @return int
	 * 		代码出错了---- -1
	 * 		账号密码错误---0
	 * 		支付密码错误---1
	 * 		余额不足----2
	 * 		支付成功----3
	 */
	public int safePay(String account, String pwd, String payPwd,
			double money, long currTimeMiles) {
		if (!account.equals("zhangsan")||!pwd.equals("123")) {
			return 0;
		}
		if (!payPwd.equals("123456")) {
			return 1;
		}
		//如果支付的金额大于1000块 说明余额不足
		if (money>1000) {
			return 2;
		}
		//如果上面都不满足 说明支付成功了!
		return 3;
	}

}
