package com.m520it.alipay;

interface IAlipayService {

	int callSafePay(String account, String pwd, String payPwd,
			double money, long currTimeMiles);
	
}
