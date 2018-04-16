package com.x.reflect;

import java.util.TreeMap;

/**
 * Created by miller on 2018/4/15
 */
public class ClassDemo1
{
    public static void main(String[] args){
        //Foo的实例对象如何表示

        Foo foo1 = new Foo();

        //Foo 这个类也是一个实例对象,Class类的实例对象,如何表示呢
        //任何一个类都是Class类的实例对象,这个实例对象有三种表示方式

        //第一种表示方式 -->实际上告诉我们任何一个类都有一个隐含的静态成员变量
        Class c1 = Foo.class;

        //第二中表达方式 已知该类的对象通过getClass方法
        Class c2 = foo1.getClass();
        /* 官网 c1,c2 表示了Foo类的类类型(class Type )
        *  万事万物皆对象
        *  类也是对象,是CLass类的实例对象
        *  这个对象我们成为该类的类类型
        * */

        //c1 和 c2 都代表了Foo类的类类型,一个类只可能是Class类的一个实例对象
        System.out.println(c1 == c2);
        Class c3 = null;
        try {

            c3 = Class.forName("com.x.reflect.Foo");
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(c2 == c3);


        //我们完全可以通过类的类类型,创建该类的对象实例---->通过 c1 or c2 or c3 创建Foo的实例对象
        try {
            Foo foo = (Foo) c1.newInstance();// 需要无参数构造方法
            foo.print();
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}

class Foo{
    void print(){
        System.out.println("Foo");
    }
}
