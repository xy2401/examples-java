package com.xy2401.example.demo.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;

public class LambdaTest {

	public static void main(String[] args) {

		String[] planets = new String[] { "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune",
				"eptune" };

		// 默认字典排序
		Arrays.sort(planets);

		int[] ints = new int[] { 1, 2, 3, 4, 5 };
		Arrays.sort(ints);

		// 使用自定义比较器方法
		Comparator<String> myComparator = new MyComparator();
		myComparator.compare("233", "SB");
		// 参数myComparator 要求是 一个实现了 Comparator 接口的类的实例
		Arrays.sort(planets, myComparator);

		// 使用匿名内部类
		Arrays.sort(planets, new Comparator<String>() {
			public int compare(String arg0, String arg1) {
				return arg0.compareToIgnoreCase(arg1);
			}
		});

		myComparator = new Comparator<String>() {
			public int compare(String arg0, String arg1) {
				return arg0.compareToIgnoreCase(arg1);
			}
		};
		// 函数式接口 对象 = 一个 lambda 的
		myComparator = (first, second) -> first.compareToIgnoreCase(second);
		myComparator = String::compareToIgnoreCase;

		// 使用 lambda表达式 函数式接口 可推导 要实现的接口
		Arrays.sort(planets, (String first, String second) -> {
			return first.compareToIgnoreCase(second);
		});

		// 方法体只有一行 可以省略 {} return ;
		Arrays.sort(planets, (String first, String second) -> first.compareToIgnoreCase(second));
		// 参数类型可以推导 可以再省略
		Arrays.sort(planets, (first, second) -> first.compareToIgnoreCase(second));
		// 方法引用
		Arrays.sort(planets, String::compareToIgnoreCase);

		// lambda 表达式 延迟执行 区别一般方法的 直接调用
		Math.addExact(3, 11);
		Math.addExact((1 + 2), (4 + 7));

		repeat(3, () -> System.out.println("SB"));
		repeat(3, i -> System.out.println("SB" + (9 - i)));
		repeat(3, (s, i) -> System.out.println(" SB " + s + " " + i));

		repeat(3, new BiConsumer<String, Integer>() {
			public void accept(String s, Integer i) {
				System.out.println(" SB " + s + " " + i);
			}
		});

		BiConsumer<String, Integer> biConsumer = new BiConsumer<String, Integer>() {
			public void accept(String s, Integer i) {
				System.out.println(" SB " + s + " " + i);
			}
		};
		repeat(3, biConsumer);

	}

	public static void repeat(int n, Runnable action) {
		for (int i = 0; i < n; i++) {
			action.run();
		}
	}

	public static void repeat(int n, IntConsumer action) {
		for (int i = 0; i < n; i++) {
			action.accept(i);
		}
	}

	public static void repeat(int n, BiConsumer<String, Integer> action) {
		for (int i = 0; i < n; i++) {
			action.accept("sb", i);
		}
	}
}
