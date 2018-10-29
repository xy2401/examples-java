package com.xy2401.example.demo.lambda;

/**
 * 编译后的方法的入参数。如何过去的?
 * @author xy
 *
 */
public class Future {
	
	public void test2() {
		System.out.println(this);
	}

	public static void main(String[] args) {
 
		//无法使用this 关键字  不能在静态上下文中使用 this
		Runnable runnable2 = () -> System.out.println("This is Runnable 1"  );
		runnable2.run();
		
		//匿名内部类 可以使用this 关键字  
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("This is Runnable 2:" + this )  ;
			}
		};
		runnable.run();
		
		
		Future Future = new Future();
		System.out.println("Future:"+Future);
		Future.test();
		

		Future Future2 = new Future();
		System.out.println("Future2:"+Future2);
		Future2.test();
	}

	public void test() {

		int i = 0;
		System.out.println("test this "+this);

		// : void = f ( ) ; 简单输出
		Runnable runnable2 = () -> System.out.println("test"+this + ":" + i);
		runnable2.run();

		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("test This is Runnable:" + this + ":" + i);
			}
		};
		runnable.run();

	}

}
