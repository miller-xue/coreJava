package com.x.reflect;

import java.lang.reflect.Method;

public class MethodDemo1 {

	public static void main(String[] args) throws Exception {
		// 要获取print(int a, int b)方法 1.要获取一个方法就是获取类的信息,获取类的信息首先要获取类的类对象
		A a = new A();
		Class clazz = a.getClass();
		// Method method = clazz.getMethod("print", int.class, int.class);
		// method.invoke(a,1,2);
		//
		/*
		 * 2.获取方法 名称和参数列表来决定 getMethod获取的是public方法 getDeclaredMethod 获取自己声明的方法
		 */
		Method method = clazz.getDeclaredMethod("print", new Class[] { String.class, String.class });
		//方法的反射操作
		//方法反射是用method对象进行方法调用和 a.print调用结果相同
		//没有返回值返回null 有返回值,返回对应的类型
		Object result = method.invoke(a, "abcd", "ABCD");
		
		System.out.println("==================");
		Method m2 = clazz.getMethod("print");
		m2.invoke(a);
	}
}

class A {
	
	public void print(){
		System.out.println("Hello Wolrd");
	}
	public void print(int a, int b) {
		System.out.println(a + b);
	}

	public void print(String a, String b) {
		System.out.println(a.toUpperCase() + "," + b.toLowerCase());
	}
}