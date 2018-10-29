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

/**
 * 参考 FunctionInterfaceTest 写一遍 匿名内部类的版本
 * 
 * @author xy
 *
 *         匿名 内部类 会编译独立的class
 *
 *         FunctionInterfaceTest2$1.class FunctionInterfaceTest2$10.class
 *         FunctionInterfaceTest2$11.class FunctionInterfaceTest2$12.class
 *         FunctionInterfaceTest2$13.class FunctionInterfaceTest2$14.class
 *         FunctionInterfaceTest2$15.class FunctionInterfaceTest2$16.class
 *         FunctionInterfaceTest2$17.class FunctionInterfaceTest2$18.class
 *         FunctionInterfaceTest2$19.class FunctionInterfaceTest2$2.class
 *         FunctionInterfaceTest2$20.class FunctionInterfaceTest2$21.class
 *         FunctionInterfaceTest2$22.class FunctionInterfaceTest2$23.class
 *         FunctionInterfaceTest2$24.class FunctionInterfaceTest2$25.class
 *         FunctionInterfaceTest2$26.class FunctionInterfaceTest2$27.class
 *         FunctionInterfaceTest2$28.class FunctionInterfaceTest2$29.class
 *         FunctionInterfaceTest2$3.class FunctionInterfaceTest2$30.class
 *         FunctionInterfaceTest2$31.class FunctionInterfaceTest2$32.class
 *         FunctionInterfaceTest2$33.class FunctionInterfaceTest2$34.class
 *         FunctionInterfaceTest2$35.class FunctionInterfaceTest2$36.class
 *         FunctionInterfaceTest2$37.class FunctionInterfaceTest2$38.class
 *         FunctionInterfaceTest2$39.class FunctionInterfaceTest2$4.class
 *         FunctionInterfaceTest2$40.class FunctionInterfaceTest2$41.class
 *         FunctionInterfaceTest2$42.class FunctionInterfaceTest2$43.class
 *         FunctionInterfaceTest2$44.class FunctionInterfaceTest2$45.class
 *         FunctionInterfaceTest2$46.class
 */
public class FunctionInterfaceTest2 {

	public static void main(String[] args) {

		Supplier<Collection<Double>> supplier = () -> new ArrayList<Double>();
		supplier.get();
		supplier.get();
		supplier.get();

		Supplier<Collection<Double>> supplier2 = new Supplier<Collection<Double>>() {
			@Override
			public Collection<Double> get() {
				// TODO 自动生成的方法存根
				return new ArrayList<Double>();
			}

		};
		supplier2.get();

		// : Z = f ( X , Y ) ; 返回 入参 两个集合的合集
		BiFunction<List<Double>, Set<Double>, List<Double>> biFunction = (first, second) -> Stream
				.concat(first.stream(), second.stream()).collect(Collectors.toList());
		biFunction.apply(new ArrayList<>(), new HashSet<>());

		BiFunction<List<Double>, Set<Double>, List<Double>> biFunction2 = new BiFunction<List<Double>, Set<Double>, List<Double>>() {
			@Override
			public List<Double> apply(List<Double> first, Set<Double> second) {
				return Stream.concat(first.stream(), second.stream()).collect(Collectors.toList());
			}
		};
		biFunction2.apply(new ArrayList<>(), new HashSet<>());

	}

	// : Z = f ( ) ; 获取一个对象
	void demo001() {
		Supplier<Collection<Double>> supplier = () -> new ArrayList<Double>();
		supplier.get();
	}

	void demo001f() {
		Supplier<Collection<Double>> supplier = new Supplier<Collection<Double>>() {
			@Override
			public Collection<Double> get() {
				// TODO 自动生成的方法存根
				return new ArrayList<Double>();
			}
		};
		supplier.get();
	}

	// 随机一个 boolean
	void demo002() {
		Supplier<Boolean> supplier = () -> new Random().nextDouble() > 0.5;
		supplier.get();
	}

	void demo002f() {
		Supplier<Boolean> supplier = new Supplier<Boolean>() {
			@Override
			public Boolean get() {
				// TODO 自动生成的方法存根
				return new Random().nextDouble() > 0.5;
			}
		};
		supplier.get();
	}

	void demo003() {
		BooleanSupplier booleanSupplier = () -> new Random().nextDouble() > 0.5;
		booleanSupplier.getAsBoolean();
	}

	void demo003f() {
		BooleanSupplier booleanSupplier = new BooleanSupplier() {
			@Override
			public boolean getAsBoolean() {
				// TODO 自动生成的方法存根
				return new Random().nextDouble() > 0.5;
			}
		};
		booleanSupplier.getAsBoolean();
	}

	// : p PSupplier.getAsP(); 返回 一个 随机 double/long/int
	void demo004() {
		DoubleSupplier doubleSupplier = () -> new Random().nextDouble();
		doubleSupplier.getAsDouble();
	}

	void demo004f() {
		DoubleSupplier doubleSupplier = new DoubleSupplier() {
			@Override
			public double getAsDouble() {
				// TODO 自动生成的方法存根
				return new Random().nextDouble();
			}
		};
		doubleSupplier.getAsDouble();
	}

	void demo005() {
		IntSupplier intSupplier = () -> new Random().nextInt();
		intSupplier.getAsInt();
	}

	void demo005f() {
		IntSupplier intSupplier = new IntSupplier() {
			@Override
			public int getAsInt() {
				// TODO 自动生成的方法存根
				return new Random().nextInt();
			}
		};
		intSupplier.getAsInt();
	}

	void demo006() {
		LongSupplier longSupplier = () -> new Random().nextLong();
		longSupplier.getAsLong();
	}

	void demo006f() {
		LongSupplier longSupplier = new LongSupplier() {
			@Override
			public long getAsLong() {
				// TODO 自动生成的方法存根
				return new Random().nextLong();
			}
		};
		longSupplier.getAsLong();
	}

	// : void = f ( X ) ; 输出 入参集合长度
	void demo007() {
		Consumer<Collection<Double>> consumer = (Collection<Double> c) -> System.out.println(c.size());
		consumer.accept(new ArrayList<>());
	}

	void demo007f() {
		Consumer<Collection<Double>> consumer = new Consumer<Collection<Double>>() {
			@Override
			public void accept(Collection<Double> arg0) {
				// TODO 自动生成的方法存根
				System.out.println(arg0.size());
			}
		};
		consumer.accept(new ArrayList<>());
	}

	// : void PConsumer.accept(p value) ; 输出 入参
	void demo008() {
		DoubleConsumer doubleConsumer = i -> System.out.println(i);
		doubleConsumer.accept(new Random().nextDouble());
	}

	void demo008f() {
		DoubleConsumer doubleConsumer = new DoubleConsumer() {
			@Override
			public void accept(double arg0) {
				// TODO 自动生成的方法存根
				System.out.println(arg0);
			}
		};
		doubleConsumer.accept(new Random().nextDouble());
	}

	void demo009() {
		IntConsumer intConsumer = i -> System.out.println(i);
		intConsumer.accept(new Random().nextInt());
	}

	void demo009f() {
		IntConsumer intConsumer = new IntConsumer() {
			@Override
			public void accept(int arg0) {
				// TODO 自动生成的方法存根
				System.out.println(arg0);
			}
		};
		intConsumer.accept(new Random().nextInt());
	}

	void demo010() {
		LongConsumer longConsumer = i -> System.out.println(i);
		longConsumer.accept(new Random().nextLong());
	}

	void demo010f() {
		LongConsumer longConsumer = new LongConsumer() {
			@Override
			public void accept(long arg0) {
				// TODO 自动生成的方法存根
				System.out.println(arg0);
			}
		};
		longConsumer.accept(new Random().nextLong());
	}

	// : Z = f ( X ) ; list 转换为 set
	void demo011() {
		Function<List<Double>, Set<Double>> function = list -> new HashSet<Double>(list);
		function.apply(new ArrayList<>());
	}

	void demo011f() {
		Function<List<Double>, Set<Double>> function = new Function<List<Double>, Set<Double>>() {
			@Override
			public Set<Double> apply(List<Double> arg0) {
				// TODO 自动生成的方法存根
				return new HashSet<Double>(arg0);
			}
		};
		function.apply(new ArrayList<>());
	}

	// : R PFunction<R>.apply(p value) ; 一个值 放入 新建集合中
	void demo012() {
		IntFunction<List<Integer>> intFunction = i -> Arrays.asList(i);
		intFunction.apply(new Random().nextInt());
	}

	void demo012f() {
		IntFunction<List<Integer>> intFunction = new IntFunction<List<Integer>>() {
			@Override
			public List<Integer> apply(int arg0) {
				// TODO 自动生成的方法存根
				return Arrays.asList(arg0);
			}
		};
		intFunction.apply(new Random().nextInt());
	}

	void demo013() {
		LongFunction<List<Long>> longFunction = i -> Arrays.asList(i);
		longFunction.apply(new Random().nextLong());
	}

	void demo013f() {
		LongFunction<List<Long>> longFunction = new LongFunction<List<Long>>() {
			@Override
			public List<Long> apply(long arg0) {
				// TODO 自动生成的方法存根
				return Arrays.asList(arg0);
			}
		};
		longFunction.apply(new Random().nextLong());
	}

	void demo014() {
		DoubleFunction<List<Double>> doubleFunction = i -> Arrays.asList(i);
		doubleFunction.apply(new Random().nextDouble());
	}

	void demo014f() {
		DoubleFunction<List<Double>> doubleFunction = new DoubleFunction<List<Double>>() {
			@Override
			public List<Double> apply(double arg0) {
				// TODO 自动生成的方法存根
				return Arrays.asList(arg0);
			}
		};
		doubleFunction.apply(new Random().nextDouble());
	}

	// : UnaryOperator<T> extends Function<T,T> ; 将 list 数据复制到 一个新的 list
	void demo015() {
		UnaryOperator<List<Double>> unaryOperator = list -> new ArrayList<>(list);
		unaryOperator.apply(new ArrayList<>());
	}

	void demo015f() {
		UnaryOperator<List<Double>> unaryOperator = new UnaryOperator<List<Double>>() {
			@Override
			public List<Double> apply(List<Double> arg0) {
				// TODO 自动生成的方法存根
				return new ArrayList<>(arg0);
			}
		};
		unaryOperator.apply(new ArrayList<>());
	}

	// : p ToPFunction<T>.applyAsP(T value) ; 返回 list 的第一项
	void demo016() {
		ToIntFunction<List<Integer>> toIntFunction = list -> list.get(0);
		toIntFunction.applyAsInt(Arrays.asList(new Random().nextInt()));
	}

	void demo016f() {
		ToIntFunction<List<Integer>> toIntFunction = new ToIntFunction<List<Integer>>() {
			@Override
			public int applyAsInt(List<Integer> arg0) {
				// TODO 自动生成的方法存根
				return arg0.get(0);
			}
		};
		toIntFunction.applyAsInt(Arrays.asList(new Random().nextInt()));
	}

	void demo017() {
		ToLongFunction<List<Long>> ToLongFunction = list -> list.size();
		ToLongFunction.applyAsLong(Arrays.asList(new Random().nextLong()));
	}

	void demo017f() {
		ToLongFunction<List<Long>> ToLongFunction = new ToLongFunction<List<Long>>() {
			@Override
			public long applyAsLong(List<Long> arg0) {
				// TODO 自动生成的方法存根
				return arg0.size();
			}
		};
		ToLongFunction.applyAsLong(Arrays.asList(new Random().nextLong()));
	}

	void demo018() {
		ToDoubleFunction<List<Double>> ToDoubleFunction = list -> list.size();
		ToDoubleFunction.applyAsDouble(Arrays.asList(new Random().nextDouble()));
	}

	void demo018f() {
		ToDoubleFunction<List<Double>> ToDoubleFunction = new ToDoubleFunction<List<Double>>() {

			@Override
			public double applyAsDouble(List<Double> arg0) {
				// TODO 自动生成的方法存根
				return arg0.size();
			}

		};
		ToDoubleFunction.applyAsDouble(Arrays.asList(new Random().nextDouble()));
	}

	// : Predicate<T>.boolean test(T t) ; 判断 list 是否为空
	void demo019() {
		Predicate<List<Double>> predicate = list -> list.isEmpty();
		predicate.test(new ArrayList<>());
	}

	void demo019f() {
		Predicate<List<Double>> predicate = new Predicate<List<Double>>() {

			@Override
			public boolean test(List<Double> arg0) {
				// TODO 自动生成的方法存根
				return arg0.isEmpty();
			}

		};
		predicate.test(new ArrayList<>());
	}

	// : boolean PPredicate.test(p value) ; 判断一个数是否 可以被2整除 , Double 特殊
	void demo020() {
		IntPredicate intPredicate = i -> i / 2 == 0;
		intPredicate.test(new Random().nextInt());
	}

	void demo020f() {
		IntPredicate intPredicate = new IntPredicate() {

			@Override
			public boolean test(int arg0) {
				// TODO 自动生成的方法存根
				return arg0 / 2 == 0;
			}

		};
		intPredicate.test(new Random().nextInt());
	}

	void demo021() {
		LongPredicate longPredicate = i -> i / 2 == 0;
		longPredicate.test(new Random().nextLong());
	}

	void demo021f() {
		LongPredicate longPredicate = new LongPredicate() {

			@Override
			public boolean test(long arg0) {
				// TODO 自动生成的方法存根
				return arg0 / 2 == 0;
			}

		};
		longPredicate.test(new Random().nextLong());
	}

	void demo022() {
		DoublePredicate doublePredicate = i -> i / 2 == 0;
		doublePredicate.test(new Random().nextDouble());
	}

	void demo022f() {
		DoublePredicate doublePredicate = new DoublePredicate() {

			@Override
			public boolean test(double arg0) {
				// TODO 自动生成的方法存根
				return arg0 / 2 == 0;
			}

		};
		doublePredicate.test(new Random().nextDouble());
	}

	// : p PToPFunction.applyAsP(p value) ; 数据类型转换 并没有 想到/找到 由什么实际的应用
	void demo023() {
		IntToDoubleFunction intToDoubleFunction = i -> (double) i;
		intToDoubleFunction.applyAsDouble(new Random().nextInt());
	}

	void demo023f() {
		IntToDoubleFunction intToDoubleFunction = new IntToDoubleFunction() {

			@Override
			public double applyAsDouble(int arg0) {
				// TODO 自动生成的方法存根
				return (double) arg0;
			}

		};
		intToDoubleFunction.applyAsDouble(new Random().nextInt());
	}

	void demo024() {
		IntToLongFunction IntToLongFunction = i -> (long) i;
		IntToLongFunction.applyAsLong(new Random().nextInt());
	}

	void demo024f() {
		IntToLongFunction IntToLongFunction = new IntToLongFunction() {

			@Override
			public long applyAsLong(int arg0) {
				// TODO 自动生成的方法存根
				return (long) arg0;
			}

		};
		IntToLongFunction.applyAsLong(new Random().nextInt());
	}

	void demo025() {
		LongToIntFunction LongToIntFunction = i -> (int) i;
		LongToIntFunction.applyAsInt(new Random().nextLong());
	}

	void demo025f() {
		LongToIntFunction LongToIntFunction = new LongToIntFunction() {

			@Override
			public int applyAsInt(long arg0) {
				// TODO 自动生成的方法存根
				return (int) arg0;
			}

		};
		LongToIntFunction.applyAsInt(new Random().nextLong());
	}

	void demo026() {
		LongToDoubleFunction LongToDoubleFunction = i -> (double) i;
		LongToDoubleFunction.applyAsDouble(new Random().nextLong());
	}

	void demo026f() {
		LongToDoubleFunction LongToDoubleFunction = new LongToDoubleFunction() {

			@Override
			public double applyAsDouble(long arg0) {
				// TODO 自动生成的方法存根
				return (double) arg0;
			}

		};
		LongToDoubleFunction.applyAsDouble(new Random().nextLong());
	}

	void demo027() {
		DoubleToIntFunction DoubleToIntFunction = i -> (int) i;
		DoubleToIntFunction.applyAsInt(new Random().nextDouble());
	}

	void demo027f() {
		DoubleToIntFunction DoubleToIntFunction = new DoubleToIntFunction() {

			@Override
			public int applyAsInt(double arg0) {
				// TODO 自动生成的方法存根
				return (int) arg0;
			}

		};
		DoubleToIntFunction.applyAsInt(new Random().nextDouble());
	}

	void demo028() {
		DoubleToLongFunction DoubleToLongFunction = i -> (long) i;
		DoubleToLongFunction.applyAsLong(new Random().nextDouble());
	}

	void demo028f() {
		DoubleToLongFunction DoubleToLongFunction = new DoubleToLongFunction() {

			@Override
			public long applyAsLong(double arg0) {
				// TODO 自动生成的方法存根
				return (long) arg0;
			}

		};
		DoubleToLongFunction.applyAsLong(new Random().nextDouble());
	}

	// : p PUnaryOperator.applyAsInt(p operand) ; 返回入参 的值+1
	void demo029() {
		IntUnaryOperator intUnaryOperator = i -> ++i;
		intUnaryOperator.applyAsInt(new Random().nextInt());
	}

	void demo029f() {
		IntUnaryOperator intUnaryOperator = new IntUnaryOperator() {

			@Override
			public int applyAsInt(int arg0) {
				// TODO 自动生成的方法存根
				return ++arg0;
			}

		};
		intUnaryOperator.applyAsInt(new Random().nextInt());
	}

	void demo030() {
		LongUnaryOperator longUnaryOperator = i -> ++i;
		longUnaryOperator.applyAsLong(new Random().nextLong());
	}

	void demo030f() {
		LongUnaryOperator longUnaryOperator = new LongUnaryOperator() {

			@Override
			public long applyAsLong(long arg0) {
				// TODO 自动生成的方法存根
				return ++arg0;
			}

		};
		longUnaryOperator.applyAsLong(new Random().nextLong());
	}

	void demo031() {
		DoubleUnaryOperator doubleUnaryOperator = i -> ++i;
		doubleUnaryOperator.applyAsDouble(new Random().nextDouble());
	}

	void demo031f() {
		DoubleUnaryOperator doubleUnaryOperator = new DoubleUnaryOperator() {

			@Override
			public double applyAsDouble(double arg0) {
				// TODO 自动生成的方法存根
				return ++arg0;
			}

		};
		doubleUnaryOperator.applyAsDouble(new Random().nextDouble());
	}

	// : void = f ( X , Y ) ; 输出 两个入参 集合的长度
	void demo032() {
		BiConsumer<List<Double>, Set<Long>> biConsumer = (first, second) -> System.out
				.println(first.size() + " " + second.size());
		biConsumer.accept(new ArrayList<>(), new HashSet<>());
	}

	void demo032f() {
		BiConsumer<List<Double>, Set<Long>> biConsumer = new BiConsumer<List<Double>, Set<Long>>() {
			@Override
			public void accept(List<Double> first, Set<Long> second) {
				// TODO 自动生成的方法存根
				System.out.println(first.size() + " " + second.size());
			}

		};
		biConsumer.accept(new ArrayList<>(), new HashSet<>());
	}

	void demo033() {
		ObjDoubleConsumer<List<Double>> objDoubleConsumer = (first, second) -> System.out
				.println(first.size() + " " + second);
		objDoubleConsumer.accept(new ArrayList<>(), new Random().nextDouble());
	}

	void demo033f() {
		ObjDoubleConsumer<List<Double>> objDoubleConsumer = new ObjDoubleConsumer<List<Double>>() {

			@Override
			public void accept(List<Double> first, double second) {
				// TODO 自动生成的方法存根
				System.out.println(first.size() + " " + second);
			}

		};
		objDoubleConsumer.accept(new ArrayList<>(), new Random().nextDouble());
	}

	void demo034() {
		ObjIntConsumer<List<Double>> objIntConsumer = (first, second) -> System.out
				.println(first.size() + " " + second);
		objIntConsumer.accept(new ArrayList<>(), new Random().nextInt());
	}

	void demo034f() {
		ObjIntConsumer<List<Double>> objIntConsumer = new ObjIntConsumer<List<Double>>() {

			@Override
			public void accept(List<Double> first, int second) {
				// TODO 自动生成的方法存根
				System.out.println(first.size() + " " + second);
			}

		};
		objIntConsumer.accept(new ArrayList<>(), new Random().nextInt());
	}

	void demo035() {
		ObjLongConsumer<List<Double>> objLongConsumer = (first, second) -> System.out
				.println(first.size() + " " + second);
		objLongConsumer.accept(new ArrayList<>(), new Random().nextLong());
	}

	void demo035f() {
		ObjLongConsumer<List<Double>> objLongConsumer = new ObjLongConsumer<List<Double>>() {

			@Override
			public void accept(List<Double> first, long second) {
				// TODO 自动生成的方法存根
				System.out.println(first.size() + " " + second);
			}

		};
		objLongConsumer.accept(new ArrayList<>(), new Random().nextLong());
	}

	// : Z = f ( X , Y ) ; 返回 入参 两个集合的合集
	void demo036() {
		BiFunction<List<Double>, Set<Double>, List<Double>> biFunction = (first, second) -> Stream
				.concat(first.stream(), second.stream()).collect(Collectors.toList());
		biFunction.apply(new ArrayList<>(), new HashSet<>());
	}

	void demo036f() {
		BiFunction<List<Double>, Set<Double>, List<Double>> biFunction = new BiFunction<List<Double>, Set<Double>, List<Double>>() {
			@Override
			public List<Double> apply(List<Double> first, Set<Double> second) {
				// TODO 自动生成的方法存根
				return Stream.concat(first.stream(), second.stream()).collect(Collectors.toList());
			}
		};
		biFunction.apply(new ArrayList<>(), new HashSet<>());
	}

	// : p ToPBiFunction<T,U>.applyAsP(T t, U u) ; 返回两个集合中的最小值
	void demo037() {
		ToIntBiFunction<List<Integer>, Set<Integer>> toIntBiFunction = (first, second) -> Math
				.min(Collections.min(first), Collections.min(second));
		toIntBiFunction.applyAsInt(new ArrayList<>(), new HashSet<>());
	}

	void demo037f() {
		ToIntBiFunction<List<Integer>, Set<Integer>> toIntBiFunction = new ToIntBiFunction<List<Integer>, Set<Integer>>() {

			@Override
			public int applyAsInt(List<Integer> first, Set<Integer> second) {
				// TODO 自动生成的方法存根
				return Math.min(Collections.min(first), Collections.min(second));
			}

		};
		toIntBiFunction.applyAsInt(new ArrayList<>(), new HashSet<>());
	}

	void demo038() {
		ToLongBiFunction<List<Long>, Set<Long>> toLongBiFunction = (first, second) -> Math.min(Collections.min(first),
				Collections.min(second));
		toLongBiFunction.applyAsLong(new ArrayList<>(), new HashSet<>());
	}

	void demo038f() {
		ToLongBiFunction<List<Long>, Set<Long>> toLongBiFunction = new ToLongBiFunction<List<Long>, Set<Long>>() {

			@Override
			public long applyAsLong(List<Long> first, Set<Long> second) {
				// TODO 自动生成的方法存根
				return Math.min(Collections.min(first), Collections.min(second));
			}

		};
		toLongBiFunction.applyAsLong(new ArrayList<>(), new HashSet<>());
	}

	void demo039() {
		ToDoubleBiFunction<List<Double>, Set<Double>> toDoubleBiFunction = (first, second) -> Math
				.min(Collections.min(first), Collections.min(second));
		toDoubleBiFunction.applyAsDouble(new ArrayList<>(), new HashSet<>());
	}

	void demo039f() {
		ToDoubleBiFunction<List<Double>, Set<Double>> toDoubleBiFunction = new ToDoubleBiFunction<List<Double>, Set<Double>>() {

			@Override
			public double applyAsDouble(List<Double> first, Set<Double> second) {
				// TODO 自动生成的方法存根
				return Math.min(Collections.min(first), Collections.min(second));
			}

		};
		toDoubleBiFunction.applyAsDouble(new ArrayList<>(), new HashSet<>());
	}

	// BiPredicate<T,U>.boolean test(T t, U u) 返回 集合1 是否 比 集合2 大
	void demo040() {
		BiPredicate<List<Double>, Set<Double>> biPredicate = (first, second) -> first.size() > second.size();
		biPredicate.test(new ArrayList<>(), new HashSet<>());
	}

	void demo040f() {
		BiPredicate<List<Double>, Set<Double>> biPredicate = new BiPredicate<List<Double>, Set<Double>>() {

			@Override
			public boolean test(List<Double> first, Set<Double> second) {
				// TODO 自动生成的方法存根
				return first.size() > second.size();
			}

		};
		biPredicate.test(new ArrayList<>(), new HashSet<>());
	}

	// : T BinaryOperator<T>.apply(T t, T u) ; 返回 入参 两个集合(list)的合集(list)
	void demo041() {
		BinaryOperator<List<Double>> binaryOperator = (first, second) -> Stream.concat(first.stream(), second.stream())
				.collect(Collectors.toList());
		binaryOperator.apply(new ArrayList<>(), new ArrayList<>());
	}

	void demo041f() {
		BinaryOperator<List<Double>> binaryOperator = new BinaryOperator<List<Double>>() {

			@Override
			public List<Double> apply(List<Double> first, List<Double> second) {
				// TODO 自动生成的方法存根
				return Stream.concat(first.stream(), second.stream()).collect(Collectors.toList());
			}

		};
		binaryOperator.apply(new ArrayList<>(), new ArrayList<>());
	}

	// : p PBinaryOperator.applyAsP(p left, p right) ; 返回 2个 入参 中的 小值
	void demo042() {
		IntBinaryOperator intBinaryOperator = (first, second) -> Math.min(first, second);
		intBinaryOperator.applyAsInt(new Random().nextInt(), new Random().nextInt());
	}

	void demo042f() {
		IntBinaryOperator intBinaryOperator = new IntBinaryOperator() {

			@Override
			public int applyAsInt(int first, int second) {
				// TODO 自动生成的方法存根
				return Math.min(first, second);
			}

		};
		intBinaryOperator.applyAsInt(new Random().nextInt(), new Random().nextInt());
	}

	void demo043() {
		LongBinaryOperator longBinaryOperator = (first, second) -> Math.min(first, second);
		longBinaryOperator.applyAsLong(new Random().nextLong(), new Random().nextLong());
	}

	void demo043f() {
		LongBinaryOperator longBinaryOperator = new LongBinaryOperator() {

			@Override
			public long applyAsLong(long first, long second) {
				// TODO 自动生成的方法存根
				return Math.min(first, second);
			}

		};
		longBinaryOperator.applyAsLong(new Random().nextLong(), new Random().nextLong());
	}

	void demo044() {
		DoubleBinaryOperator doubleBinaryOperator = (first, second) -> Math.min(first, second);
		doubleBinaryOperator.applyAsDouble(new Random().nextDouble(), new Random().nextDouble());
	}

	void demo044f() {
		DoubleBinaryOperator doubleBinaryOperator = new DoubleBinaryOperator() {

			@Override
			public double applyAsDouble(double first, double second) {
				// TODO 自动生成的方法存根
				return Math.min(first, second);
			}

		};
		doubleBinaryOperator.applyAsDouble(new Random().nextDouble(), new Random().nextDouble());
	}
}
