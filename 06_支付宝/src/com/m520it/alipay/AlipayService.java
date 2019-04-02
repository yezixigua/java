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
	 * @param account  �˺�
	 * @param pwd	����
	 * @param payPwd	֧������
	 * @param money	֧�����
	 * @param currTimeMiles ��ǰ��ʱ���
	 * @return int
	 * 		���������---- -1
	 * 		�˺��������---0
	 * 		֧���������---1
	 * 		����----2
	 * 		֧���ɹ�----3
	 */
	public int safePay(String account, String pwd, String payPwd,
			double money, long currTimeMiles) {
		if (!account.equals("zhangsan")||!pwd.equals("123")) {
			return 0;
		}
		if (!payPwd.equals("123456")) {
			return 1;
		}
		//���֧���Ľ�����1000�� ˵������
		if (money>1000) {
			return 2;
		}
		//������涼������ ˵��֧���ɹ���!
		return 3;
	}

}
