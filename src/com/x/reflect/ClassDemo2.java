package com.x.reflect;

/**
 * Created by miller on 2018/4/15
 */
public class ClassDemo2 {
    public static void main(String[] args){
        Class c1 = int.class; //int 的类类型
        Class c2 = String.class;  //String类的类类型 String类的字节码
        Class c3 = double.class;
        Class c4 = Double.class;

        Class c5 = void.class;

        System.out.println(c1.getName());
        System.out.println(c2.getName());
        System.out.println(c2.getSimpleName()); //不带包名的类名称
        System.out.println(c5.getName());
    }
}
