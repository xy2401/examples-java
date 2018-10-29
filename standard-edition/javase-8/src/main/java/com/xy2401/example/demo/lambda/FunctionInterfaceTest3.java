package com.xy2401.example.demo.lambda;


/**
 * 
 * 
    匿名内部内 编译后就是一个新的类
   拉姆达表达式编译后 就是函数调用
   
   lambda 表达式 语法 层面 等于 函数式 接口的 一个实例  虚拟机层面 等于 函数调用
所以 lambda 表达式  不是 语法糖 而是 有甜味 的 药丸

lambda 表达式 this 所以他是一个函数 并且是非静态函数(静态函数不可以调用this)



$ javap -c -p  FunctionInterfaceTest3.class

Compiled from "FunctionInterfaceTest3.java"
public class com.xy2401.example.demo.lambda.FunctionInterfaceTest3 {
  public com.xy2401.example.demo.lambda.FunctionInterfaceTest3();
    Code:
       0: aload_0
       1: invokespecial #8                  // Method java/lang/Object."<init>":()V
       4: return

  public static void main(java.lang.String[]);
    Code:
       0: new           #1                  // class com/xy2401/example/demo/lambda/FunctionInterfaceTest3
       3: dup
       4: invokespecial #16                 // Method "<init>":()V
       7: astore_1
       8: aload_1
       9: invokevirtual #17                 // Method thisTest1:()V
      12: aload_1
      13: invokevirtual #20                 // Method thisTest2:()V
      16: return

  public void thisTest1();
    Code:
       0: new           #26                 // class com/xy2401/example/demo/lambda/FunctionInterfaceTest3$1
       3: dup
       4: aload_0
       5: invokespecial #28                 // Method com/xy2401/example/demo/lambda/FunctionInterfaceTest3$1."<init>":(Lcom/xy2401/example/demo/lambda/FunctionInterfaceTest3;)V
       8: astore_1
       9: aload_1
      10: invokeinterface #31,  1           // InterfaceMethod java/lang/Runnable.run:()V
      15: return

  public void thisTest2();
    Code:
       0: aload_0
       1: invokedynamic #38,  0             // InvokeDynamic #0:run:(Lcom/xy2401/example/demo/lambda/FunctionInterfaceTest3;)Ljava/lang/Runnable;
       6: astore_1
       7: aload_1
       8: invokeinterface #31,  1           // InterfaceMethod java/lang/Runnable.run:()V
      13: return

  private void lambda$0();
    Code:
       0: getstatic     #43                 // Field java/lang/System.out:Ljava/io/PrintStream;
       3: new           #49                 // class java/lang/StringBuilder
       6: dup
       7: ldc           #51                 // String This is Runnable:
       9: invokespecial #53                 // Method java/lang/StringBuilder."<init>":(Ljava/lang/String;)V
      12: aload_0
      13: invokevirtual #56                 // Method java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      16: invokevirtual #60                 // Method java/lang/StringBuilder.toString:()Ljava/lang/String;
      19: invokevirtual #64                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      22: return
}


 * @author xy
 *
 */
public class FunctionInterfaceTest3 {

	public static void main(String[] args) {

		FunctionInterfaceTest3 functionInterfaceTest3 = new FunctionInterfaceTest3();
		functionInterfaceTest3.thisTest1();
		functionInterfaceTest3.thisTest2();

	}

	/**

	 * 
	 */
	public void thisTest1() {
		Runnable runnable = new Runnable() {
			public void run() {
				System.out.println("This is Runnable:" + this);
			}
		};
		runnable.run();
		//FunctionInterfaceTest3$1@383534aa
 

	}
	
	/**
	 * 
	 *   public void thisTest2();
    Code:
       0: aload_0
       1: invokedynamic #38,  0             // InvokeDynamic #0:run:(Lcom/xy2401/example/demo/lambda/FunctionInterfaceTest3;)Ljava/lang/Runnable;
       6: astore_1
       7: aload_1
       8: invokeinterface #31,  1           // InterfaceMethod java/lang/Runnable.run:()V
      13: return
	 * 
	 */
	public void thisTest2() {
		 
		Runnable runnable2 = () -> System.out.println("This is Runnable:" + this);
		runnable2.run();
		//FunctionInterfaceTest3@42f30e0a

	}

}
