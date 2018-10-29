package com.xy2401.example.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongSupplier;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongBiFunction;
import java.util.function.ToLongFunction;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/*
 * 函数式接口测试
 * 
 * TODO 对比 kotlin 没有这么多的烦人的接口定义
 * 
 */
public class FunctionInterfaceTest {

	public static void main(String[] args) {

		//: void = f ( ) ;  简单输出
		Runnable runnable = () -> System.out.println("This is Runnable");
		runnable.run();
		
		//: Z = f ( ) ; 获取一个对象
		Supplier<Collection<Double>> supplier = () -> new ArrayList<Double>();
		supplier.get();
		
		//随机一个 boolean 
		Supplier<Boolean> supplier2 = () -> new Random().nextDouble() > 0.5;
		supplier2.get();
		
		BooleanSupplier booleanSupplier = () -> new Random().nextDouble() > 0.5 ;
		booleanSupplier.getAsBoolean();
		
		// : p PSupplier.getAsP();  返回 一个 随机  double/long/int 
		DoubleSupplier doubleSupplier = () -> new Random().nextDouble() ;
		doubleSupplier.getAsDouble();
		
		IntSupplier intSupplier = () -> new Random().nextInt() ;
		intSupplier.getAsInt();
		
		LongSupplier longSupplier = () -> new Random().nextLong();
		longSupplier.getAsLong();
		
		//: void = f ( X ) ; 输出 入参集合长度
		Consumer<Collection<Double>> consumer = (Collection<Double> c) -> System.out.println(c.size()); 
		consumer.accept(new ArrayList<>());
		
		//: void PConsumer.accept(p value) ;  输出 入参
		DoubleConsumer doubleConsumer = i -> System.out.println(i); 
		doubleConsumer.accept(new Random().nextDouble());
		
		IntConsumer intConsumer = i -> System.out.println(i); 
		intConsumer.accept(new Random().nextInt());
		
		LongConsumer longConsumer = i -> System.out.println(i); 
		longConsumer.accept(new Random().nextLong());
		
		// : Z = f ( X )  ;  list 转换为  set
		Function<List<Double>,Set<Double>> function = list -> new HashSet<Double>(list);
		function.apply(new ArrayList<>());
		
		// : R PFunction<R>.apply(p value) ;  一个值  放入 新建集合中
		IntFunction<List<Integer>>  intFunction = i ->  Arrays.asList(i);
		intFunction.apply(new Random().nextInt());
		
		LongFunction<List<Long>>  longFunction = i ->  Arrays.asList(i);
		longFunction.apply(new Random().nextLong());
		
		DoubleFunction<List<Double>>  doubleFunction = i ->  Arrays.asList(i);
		doubleFunction.apply(new Random().nextDouble());
		
		// : UnaryOperator<T> extends Function<T,T> ; 将  list 数据复制到 一个新的 list
		UnaryOperator<List<Double>> unaryOperator = list -> new ArrayList<>(list);
		unaryOperator.apply(new ArrayList<>());
		
		//: p ToPFunction<T>.applyAsP(T value) ; 返回 list 的第一项
		ToIntFunction<List<Integer>> toIntFunction = list -> list.get(0);
		toIntFunction.applyAsInt(Arrays.asList(new Random().nextInt()));
		
		ToLongFunction<List<Long>> ToLongFunction = list -> list.size();
		ToLongFunction.applyAsLong(Arrays.asList(new Random().nextLong()));
		
		ToDoubleFunction<List<Double>> ToDoubleFunction = list -> list.size();
		ToDoubleFunction.applyAsDouble(Arrays.asList(new Random().nextDouble()));
		
		//: Predicate<T>.boolean test(T t) ; 判断 list 是否为空
		Predicate<List<Double>> predicate = list -> list.isEmpty();
		predicate.test(new ArrayList<>());
		
		// : boolean 	PPredicate.test(p value) ;  判断一个数是否 可以被2整除 , Double 特殊
		IntPredicate intPredicate  = i -> i/2==0;
		intPredicate.test(new Random().nextInt());
		
		LongPredicate longPredicate  = i -> i/2==0;
		longPredicate.test(new Random().nextLong());
		
		DoublePredicate doublePredicate  = i -> i/2==0;
		doublePredicate.test(new Random().nextDouble());
		
		//: p PToPFunction.applyAsP(p value) ;  数据类型转换  并没有 想到/找到 由什么实际的应用
		IntToDoubleFunction intToDoubleFunction = i -> (double)i;
		intToDoubleFunction.applyAsDouble(new Random().nextInt());
		
		IntToLongFunction IntToLongFunction = i -> (long)i;
		IntToLongFunction.applyAsLong(new Random().nextInt());
		
		LongToIntFunction LongToIntFunction = i -> (int)i;
		LongToIntFunction.applyAsInt(new Random().nextLong());
		
		LongToDoubleFunction LongToDoubleFunction = i -> (double)i;
		LongToDoubleFunction.applyAsDouble(new Random().nextLong());
		
		DoubleToIntFunction DoubleToIntFunction = i -> (int)i;
		DoubleToIntFunction.applyAsInt(new Random().nextDouble());
		
		DoubleToLongFunction DoubleToLongFunction = i -> (long)i;
		DoubleToLongFunction.applyAsLong(new Random().nextDouble());
		
		//: p PUnaryOperator.applyAsInt(p operand) ; 返回入参 的值+1
		IntUnaryOperator intUnaryOperator = i -> ++i ;
		intUnaryOperator.applyAsInt(new Random().nextInt());
		
		LongUnaryOperator longUnaryOperator = i -> ++i ;
		longUnaryOperator.applyAsLong(new Random().nextLong());
		
		DoubleUnaryOperator doubleUnaryOperator = i -> ++i ;
		doubleUnaryOperator.applyAsDouble(new Random().nextDouble());
		
		
		// : void = f ( X , Y ) ; 输出 两个入参 集合的长度
		BiConsumer<List<Double>, Set<Long>> biConsumer = (first ,second) -> System.out.println(first.size() + " " + second.size());
		biConsumer.accept(new ArrayList<>(), new HashSet<>());
		
		ObjDoubleConsumer<List<Double>> objDoubleConsumer = (first ,second) -> System.out.println(first.size() + " " + second);
		objDoubleConsumer.accept(new ArrayList<>(), new Random().nextDouble() );
		
		ObjIntConsumer<List<Double>> objIntConsumer = (first ,second) -> System.out.println(first.size() + " " + second);
		objIntConsumer.accept(new ArrayList<>(), new Random().nextInt() );
		
		ObjLongConsumer<List<Double>> objLongConsumer = (first ,second) -> System.out.println(first.size() + " " + second);
		objLongConsumer.accept(new ArrayList<>(),new Random().nextLong() );
		
		// : Z = f ( X , Y ) ;  返回 入参 两个集合的合集 
		BiFunction<List<Double>, Set<Double>,List<Double>> biFunction = (first ,second) -> Stream.concat( first.stream(), second.stream()).collect(Collectors.toList());
		biFunction.apply(new ArrayList<>(), new HashSet<>());
		
		// : p ToPBiFunction<T,U>.applyAsP(T t, U u) ; 返回两个集合中的最小值
		ToIntBiFunction<List<Integer>, Set<Integer>> toIntBiFunction = (first ,second) -> Math.min(Collections.min(first), Collections.min(second));
		toIntBiFunction.applyAsInt(new ArrayList<>(), new HashSet<>());
		
		ToLongBiFunction<List<Long>, Set<Long>> toLongBiFunction = (first ,second) -> Math.min(Collections.min(first), Collections.min(second));
		toLongBiFunction.applyAsLong(new ArrayList<>(), new HashSet<>());
		
		ToDoubleBiFunction<List<Double>, Set<Double>> toDoubleBiFunction = (first ,second) -> Math.min(Collections.min(first), Collections.min(second));
		toDoubleBiFunction.applyAsDouble(new ArrayList<>(), new HashSet<>());
		
		// BiPredicate<T,U>.boolean test(T t, U u) 返回 集合1 是否 比 集合2 大
		BiPredicate<List<Double>, Set<Double>> biPredicate = (first ,second) -> first.size() > second.size();
		biPredicate.test(new ArrayList<>(), new HashSet<>());
		
		//: T BinaryOperator<T>.apply(T t, T u) ; 返回 入参 两个集合(list)的合集(list) 
		BinaryOperator<List<Double>> binaryOperator =  (first ,second) -> Stream.concat( first.stream(), second.stream()).collect(Collectors.toList());
		binaryOperator.apply(new ArrayList<>(), new ArrayList<>());
		
		// : p PBinaryOperator.applyAsP(p left, p right) ; 返回 2个 入参 中的 小值  
		IntBinaryOperator intBinaryOperator = (first ,second) -> Math.min(first, second);
		intBinaryOperator.applyAsInt(new Random().nextInt() , new Random().nextInt());
		
		LongBinaryOperator longBinaryOperator = (first ,second) -> Math.min(first, second);
		longBinaryOperator.applyAsLong(new Random().nextLong() , new Random().nextLong());
		
		DoubleBinaryOperator doubleBinaryOperator = (first ,second) -> Math.min(first, second);
		doubleBinaryOperator.applyAsDouble(new Random().nextDouble() , new Random().nextDouble());
		
	}

 

}
