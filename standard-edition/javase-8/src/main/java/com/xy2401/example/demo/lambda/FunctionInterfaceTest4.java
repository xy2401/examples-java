package com.xy2401.example.demo.lambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;
 
/**
 *   函数式接口的 的 默认方法和静态方法的使用
 *  为了方便  所以接口 有了  这两种方法
 *  静态方法  可以直接在类上调用 和 类的实例没有关系  所以 就算 接口 不能直接 new 实例 也可以有静态方法 
 * @author xy
 *
 */
public class FunctionInterfaceTest4 {

	public static void main(String[] args) {

		// 第一个 函数调用完 再给第二个函数调用
		//f(x) = x + x + 2 = 2x+2 
		Consumer<LongAdder> consumer1 = i -> i.add( i.longValue() + 2 );
		//g(x)=x+x*2=3x
		Consumer<LongAdder> consumer2 = i -> i.add( i.longValue() * 2 );
		
		//累加器 0
		LongAdder longAdder = new LongAdder();
		
		//consumer1.accept(longAdder);consumer2.accept(longAdder)
		consumer1.andThen(consumer2).accept(longAdder) ;
		
		//
		// (2*0+2) * 3 = 6
		System.out.println(longAdder );
		consumer2.andThen(consumer1).accept(longAdder) ;
		//consumer2.accept(longAdder);consumer1.accept(longAdder);
		// 3x
		// 2*(3x)+2=6*x+2 = 6*6+2=38
		// 6*2+6 +((6*2+6)+2) = 38
		System.out.println(longAdder );
		
		
		//
		IntUnaryOperator intUnaryOperator = i -> ++i;
		intUnaryOperator.applyAsInt(new Random().nextInt());

		// andThen compose 两个 方法 出参 入参 一样  所以 可以把 第一个函数的出参 作为 第二个函数的入参
		
		// f(x) = x + 2
		IntUnaryOperator f = i -> i + 2;
		// g(x) = x * 2
		IntUnaryOperator g = i -> i * 2;

		// f( 7 ) = x + 2 = 7 + 2 = 9
		System.out.println(f.applyAsInt(7));
		// g( 7 ) = 7 * 2 = 7 * 2 = 14
		System.out.println(g.applyAsInt(7));

		// g( f(x) ) = ( x + 2 ) * 2 = ( 7 + 2 ) * 2 = 18 
		System.out.println( f.andThen(g).applyAsInt(7) );
		// f( g(x) ) = ( x * 2 ) + 2 = ( 7 * 2 ) + 2 = 16
		System.out.println( f.compose(g).applyAsInt(7) );

		// f(x) = x = 7
		System.out.println( IntUnaryOperator.identity().applyAsInt(7) );
		
		
		LongAdder longAdder1 = new LongAdder();
		LongAdder longAdder2 = new LongAdder();
		
		longAdder1.add(7);
		longAdder2.add(11);
		
		//如果刚好 诺干的比较器  雇员的工资比较器 c1   年限比较器c2   技术等级比较器c3  用来给员工列表排序
		//就可以直接 使用 c1 c2 c3 生成   b1.max 获取工资高的 人  b2.max 获取年限高的  人  b3.max 获得技术高的 人
		
		//三目运算符/三元运算符/条件运算符
		//<表达式1> ? <表达式2> : <表达式3>; 
		//写法固定 所以 可以 由 比较器 应用在 BinaryOperator.maxBy 上 直接生成 不用自己写
		BinaryOperator<LongAdder> binaryOperator = (first ,second) -> first.longValue()>second.longValue() ? first : second ;
		System.out.println(binaryOperator.apply(longAdder1, longAdder2));
		 
		//long 无法转换 int 这里不严谨
		Comparator<LongAdder> comparator =  (a,b) -> a.intValue() - b.intValue();
		System.out.println(comparator.compare(longAdder1, longAdder2));
		
		Math.max(5, 6);//
		//BinaryOperator.maxBy(comparator)
		//(a, b) -> comparator.compare(a, b) >= 0 ? a : b
		System.out.println(BinaryOperator.maxBy(comparator).apply(longAdder1, longAdder2));
		
		
		//等价
		LongAdder longAdder4 = (longAdder1.intValue()-longAdder2.intValue() > 0) ? longAdder1 : longAdder2;
		BinaryOperator.maxBy(comparator).apply(longAdder1, longAdder2);
		
		
		
		Math.min(5, 6);
		BinaryOperator.minBy((LongAdder a, LongAdder b) -> a.intValue() - b.intValue())
				.apply(longAdder1, longAdder2) ;
		

		System.out.println(longAdder1 +" "+longAdder2  );

		
		/***
		 * 
		 * 
		 * Predicate<T> https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
		 * boolean 	test(T t)
		 * default Predicate<T>
		 * default Predicate<T> 	negate()
		 * static <T> Predicate<T> 	isEqual(Object targetRef)
		 * default Predicate<T> 	and(Predicate<? super T> other)
		 * 
		 * 静态方法 与 默认 方法的不同  静态方法在接口上调用 默认方法在 接口的一个实例上调用
		 * 
		 * BiPredicate<T,U> 由于 是两个入参数 所以没有 Predicate的静态方法判断是否相等
		 * 
		 * 
		 */
		//判断这个 计数器 是否到 2的倍数
		Predicate<LongAdder> predicate = i -> i.longValue()%2==0; 
		//判断这个 计数器 是否到 3的倍数
		Predicate<LongAdder> predicate2 = i -> i.longValue()%3==0; 
		System.out.println( predicate.test(longAdder1) );
		//且   predicate.test()&&predicate2.test()
		predicate.and(predicate2).test(longAdder1);
		//或  predicate.test()||predicate2.test()
		predicate.or(predicate2).test(longAdder1);
		//取反 !predicate.test(t)
		predicate.negate().test(longAdder1);
		//判断是否相等
		Predicate.isEqual(longAdder2).test(longAdder1);
		
		
	}

}
