package com.x.reflect;

/**
 * Created by miller on 2018/4/16
 */
public class ClassDemo3 {
    public static void main(String[] args){
        String s = "Hello";
//        ClassUtil.printClassMessage(s);
//        ClassUtil.printClassMessage(new Integer(1));


        ClassUtil.printFieldMessage(Integer.class);
    }
}
