package com.xy2401.example.demo.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

	public static void main(String[] args) {

		System.out.println(11);

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 5, 7, 12, 13, 14, 16, 18, 19, 51, 31);

		System.out.println(list.stream().count());
		System.out.println(list.stream().filter(i -> i % 3 == 0).count());
		
		
		System.out.println("惰性加载不执行");
		list.stream().peek(i -> System.out.println("惰性"+i)).filter(i -> i % 3 == 0).peek(i -> System.out.println(i));

		System.out.println("由终止操作会执行");
		list.stream().peek(i -> System.out.println("终止"+i)).filter(i -> i % 3 == 0).peek(i -> System.out.println(i)).count();

		
		Stream<Double> randoms = Stream.generate(Math::random);

		System.out.println(1);
		
		
		Stream.of("one", "two", "three", "four", "23333")
		 .filter(e -> e.length() > 3)
		 .peek(e -> System.out.println("Filtered value: " + e))
		 .map(String::toUpperCase)
 
		 .peek(e -> System.out.println("Mapped value: " + e))
		 .collect(Collectors.toList());
		
	}

}
