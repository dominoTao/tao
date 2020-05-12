package com.tao.core.encryption;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	public static void main(String[] args) {
//		SecureRandom random = new SecureRandom();
//		byte[] test = new byte[20];
//		for(int i = 0 ; i < test.length; i++) {
//			System.out.print(test[i]+"\t");
//			//0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	
//		}
//		System.out.println();
//		random.nextBytes(test);//将给定的字符数组随机赋值
//		for(int i = 0 ; i < test.length; i++) {
//			System.out.print(test[i]+"\t");
//			//一次测试数据
//			//91	21	-98	67	-40	52	-78	121	-81	-89	-87	81	85	-27	-36	-62	
//		}
//		System.out.println();
//		byte[] seed = random.generateSeed(20);
//		for(int i = 0 ; i < seed.length; i++) {
//			System.out.print(seed[i]+"\t");
//			//-59	-115	67	-111	-112	37	-121	91	-35	-56	-10	92	85	-2	83	-73	-21	-49	77	-104	
//		}
		generateCakes(10, 20, 15);
	}
	private static List<List<Integer>> generateCakes(int num, int seedLength, int rowLen){
		SecureRandom random = new SecureRandom();
		byte[] seeds = SecureRandom.getSeed(seedLength);//这个数组中的数通常可以用来做其他随机生成器的种子
		int counter = 0, realCount = 0, tmprows = 0;
		List<List<Integer>> CakesList = new ArrayList<List<Integer>>();
		while(num > tmprows) {
			List<Integer> list = new ArrayList<Integer>();
			while(counter < rowLen) {
				random.setSeed(seeds);//设置种子
				int cake = random.nextInt(38);//随机生成0-37的数字
				if(!list.contains(cake) && 0 != cake) {
					list.add(cake);
					counter++;
				}
				random.nextBytes(seeds);//随机获取新的byte数组用以作为下次的种子，不断循环
				realCount++;
			}
			
			Collections.sort(list);
			tmprows++;
			counter = 0;
			CakesList.add(list);
		}
		System.out.println("乱数取得回数："+realCount);
		return CakesList;
	}
}


