package com.x.reflect;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class MethodDemo2 {
	public static void main(String[] args) {
		// TODO
		ArrayList lists1 = new ArrayList<>();

		ArrayList<String> lists2 = new ArrayList<String>();
		lists2.add("hello");
		// lists2.add(20); 错误的
		Class c1 = lists1.getClass();
		Class c2 = lists2.getClass();

		System.out.println(c1 == c2);
		// 反射的操作都是编译之后的操作(都在运行时候的操作)

		/**
		 * c1 == c2结果返回true说明编译之后集合的泛型是去泛型化的 
		 * java集合中的泛型,是防止错误输入的,只在便宜阶段有效果.
		 * 绕过便宜就无效了
		 */
		
		try{
			Method add = c2.getMethod("add", Object.class);
			add.invoke(lists2, 213);//编译就绕过了泛型
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(lists2.toString());
	}
}
