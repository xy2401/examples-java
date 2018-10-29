package com.xy2401.example.demo.lambda;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 拉姆达 表达式简化之路
 * 
 * @author xy
 *
 */
public class FunctionInterfaceTest6 {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("123", "321", "123", "123", "123", "1", "23333", "sb", "abcd");

		System.out.println(list);

		// 默认排序字典排序
		Collections.sort(list);
		System.out.println(list);

		// 实例化自定义比较器 接收两个 对象 并且返回一个 int
		// 问题 1 为什么要 new ?? 只是想调用比较方法 new 示例 出来 会由额外的开销( 创建实例的开销 和 销毁实例的开销)
		LengthComparator lengthComparator = new LengthComparator();

		Collections.sort(list, lengthComparator);
		System.out.println(list);

		// 使用 匿名内部类的写法 减少 额外的 java 类文件的书写
		// 但是 实际上 匿名内部类 还是会编译成 独立的 class 文件
		// 名字为 当前类名$1 这样的形势
		// FunctionInterfaceTest3$1.class
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				return o2.length() - o1.length();
			}
		});
		System.out.println(list);

		// lamdba 表达式版本
		// sort 方法第二个 入参 Comparator 指定 lamdba 表达式对应的函数式接口
		Collections.sort(list, (String o1, String o2) -> {
			return o1.length() - o2.length();
		});
		System.out.println(list);

		// lamdba 类型可以推断(泛型约束) 所以 表达式 入参数类型可以省略
		Collections.sort(list, (o1, o2) -> {
			return o2.length() - o1.length();
		});
		System.out.println(list);

		// lamdba 表达式 实际代码如果只有一行 可以再省略 { } 括号 和 return ; 分号
		Collections.sort(list, (o1, o2) -> o1.length() - o2.length());
		System.out.println(list);

		// 再简化
		Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
		System.out.println(list);
		// 由上面再简化
		Collections.sort(list, String::compareTo);
		System.out.println(list);
		// 由上面再简化
		Collections.sort(list, String::compareToIgnoreCase);
		
		 
		
		System.out.println(list);

		// 所有的函数式接口都可以使用 lamdba 表达式
		// lamdba 表达式 == 函数式接口 约等于
		Comparator<String> lengthComparator2 = new LengthComparator();
		Comparator<String> lengthComparator3 = (o1, o2) -> o1.length() - o2.length();
		// 如果没有泛型 类型推断就只能到 Object 类型
		Comparator lengthComparator4 = (o1, o2) -> o1.toString().length() - o2.toString().length();
		// 如果 是 jdk11 则不能在 lamdba 表达式 前的变量 使用 var 类型 没有足够的信息进行类型推导
		// var lengthComparator4 = (o1, o2) ->
		// o1.toString().length()-o2.toString().length();

		// lamdba 表达式 == 函数式接口 的实例 约等于
		sort(list, (o1, o2) -> o1.length() - o2.length(), (o1, o2) -> o2.length() - o1.length());
	}

	/*
	 * lamdba 表达式 == 函数式接口 约等于
	 */
	static <T> void sort(List<T> list, Comparator<? super T> c, Comparator<? super T> c2) {
		// 心情好用第一个比较器 心情不好 就用第二个比较器
		if (Math.random() > 0.5) {
			list.sort(c);
		} else {
			list.sort(c2);
		}

	}
}
