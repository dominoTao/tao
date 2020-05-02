package com.tao.core.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;


@BenchmarkMode(Mode.Throughput)// �������ͣ�������.
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS) // Ԥ�� 2 �֣�ÿ�� 1s
@Measurement(iterations = 5, time = 3, timeUnit = TimeUnit.SECONDS)// ���� 5 �֣�ÿ�� 3s
@Fork(1) // fork 1 ���߳�
@State(Scope.Thread) // ÿ�������߳�һ��ʵ��
public class HashMapCycle {
	static Map<Integer, String> map = new HashMap<Integer, String>() {
		private static final long serialVersionUID = 1L;

	{
		for (int i = 0; i < 10; i++) { // �������
			put(i, "value:"+i);
		}
	}};
	
	public static void main(String[] args) {
		Options opt = new OptionsBuilder()
				.include(HashMapCycle.class.getSimpleName())// Ҫ����Ĳ�����
				.output("C:\\Users\\Administrator\\Desktop\\jmh-log.log")// ������Խ�����ļ�
				.build();
		try {
			new Runner(opt).run();
		} catch (RunnerException e) {
			e.printStackTrace();
		}
	}

	/** ���б������ @Benchmark ע��ķ������ᱻ���� */
    @Benchmark
    public void entrySet() {
        // ����
        Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
    @Benchmark
    public void keySet() {
        // ����
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Benchmark
    public void forEachEntrySet() {
        // ����
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }

    @Benchmark
    public void forEachKeySet() {
        // ����
        for (Integer key : map.keySet()) {
            System.out.println(key);
            System.out.println(map.get(key));
        }
    }

    @Benchmark
    public void lambda() {
        // ����
        map.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value);
        });
    }

    @Benchmark
    public void streamApi() {
        // ���̱߳���
        map.entrySet().stream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }

    @Benchmark
    public void parallelStreamApi() {
        // ���̱߳���
        map.entrySet().parallelStream().forEach((entry) -> {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        });
    }
}
