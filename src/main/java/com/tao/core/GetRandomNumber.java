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
		//������ת��int,��������[0, 100)�����int����
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
		//����[0, 100)�����int����
		return random.nextInt(100);
	}
	//error
	public static void getRandom4() {
		//��ָ�����㷨������ָ���˰�������   sr = SecureRandom.getInstance("SHA1PRING", "RUN");
		SecureRandom sr;
		try {
			//ϵͳ��ȷ���������Ƿ�����������㷨ʵ�֣��Ƿ��ж�����Ƿ�����ѡʵ�֡�
			sr = SecureRandom.getInstance("SHA1PRING");//java.security.NoSuchAlgorithmException: SHA1PRING SecureRandom not available
			Integer i1 = sr.nextInt();//����10λ�������
			Integer i2 = sr.nextInt(100);//����0-99�������
			System.out.println(i1+"\t"+i2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} 
	}
}
