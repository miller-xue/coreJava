package com.x.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by miller on 2018/4/16
 */
public class ClassUtil {

    /**
     * 打印类的信息,包括类的成员函数,成员变量
     *
     * @param obj 该对象所属类的信息
     */
    public static void printClassMessage(Object obj) {
        Class clazz = obj.getClass(); //传递的是那个子类的对象,clazz就是该子类的类类型

        //获取类的名称
        System.out.println("类的名称是" + clazz.getName());

        /**
         * Method类, 方法对象
         * 一个成员方法就是一个Method对象
         * getMethods()方法获取的是所有public的函数,包括父类继承而来的
         *
         * getDeclaredMethods() 获得的是所有该类自己声明的方法,不问访问权限.
         */
        Method[] methods = clazz.getMethods();// clazz.getDeclaredMethods()
        for (Method method : methods) {
            //得到方法返回值类型的类类型
            Class returnType = method.getReturnType();
            System.out.print(returnType.getName() + " ");

            //得到方法的名称
            System.out.print(method.getName() + "(");
            //获取参数类型
            Class[] paramTypes = method.getParameterTypes();
            for (Class c : paramTypes) {
                System.out.print(c.getName() + " ");
            }
            System.out.println(")");


        }
    }

    public static void printFieldMessage(Class clazz) {
        /**
         * 成员变量也是对象
         * java.lang.reflect.Field
         * Field类封装了关于成员变量的操作
         */
//        Field[] fields = clazz.getFields();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            Class fieldType = field.getType();
            String typeName = fieldType.getTypeName();
            //得到成员变量的名称
            String name = field.getName();
            System.out.println(typeName + " " + name);
        }
    }

    /**
     * 打印对象的构造函数的信息
     *
     * @param clazz
     */
    public static void printConMessage(Class clazz) {
        /**
         * 构造函数也是对象
         * java.lang.Constructor中封装了构造函数信息
         * getConstructors 获得所有public的构造函数
         * getDeclaredConstructors 得到自己声明的构造函数
         */
//       Constructor[] constructors =  clazz.getConstructors();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors
                ) {
            System.out.print(c.getName() + "(");
            //获取构造函数的参数列表 ---> 得到的是参数列表的类类型
            Class[] paramTypes = c.getParameterTypes();
            for (Class cs: paramTypes
                 ) {
                System.out.print(cs.getName() +",");

            }
            System.out.println(")");

        }
    }
}
