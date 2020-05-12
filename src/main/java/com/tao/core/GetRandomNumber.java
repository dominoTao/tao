package com.tao.core;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

public class GetRandomNumber {
	public static void main(String[] args) {
		getRandom4();
	}
	public static int getRandom1() {
		long num = System.currentTimeMillis();
		//毫秒数转成int,比如生成[0, 100)的随机int整数
		int i = (int)(num % 100);
		return i;
	}
	public static int getRandom2() {
		double random = Math.random();
		int i = (int)(random * 100);
		return i;
	}
	public static int getRandom3() {
		Random random = new Random();
		//生成[0, 100)的随机int整数
		return random.nextInt(100);
	}
	//error
	public static void getRandom4() {
		//即指定了算法名，又指定了包报程序   sr = SecureRandom.getInstance("SHA1PRING", "RUN");
		SecureRandom sr;
		try {
			//系统将确定环境中是否有所请求的算法实现，是否有多个，是否有首选实现。
			sr = SecureRandom.getInstance("SHA1PRING");//java.security.NoSuchAlgorithmException: SHA1PRING SecureRandom not available
			Integer i1 = sr.nextInt();//生成10位的随机数
			Integer i2 = sr.nextInt(100);//生成0-99的随机数
			System.out.println(i1+"\t"+i2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
	}
}
