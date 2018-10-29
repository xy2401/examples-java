package com.xy2401.example.demo.lambda;

import java.util.Comparator;

/**
 * 自定义比较器类 , 实现了比较器接口 Comparator 使用 两个 字符串的 长度 进行比较
 * 
 * 
 * @author xy
 *
 */
public class LengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {

		return o1.length() - o2.length();
	}

}
