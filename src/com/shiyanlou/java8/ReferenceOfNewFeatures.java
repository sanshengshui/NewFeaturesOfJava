package com.shiyanlou.java8;

import java.util.ArrayList;
import java.util.List;

/*
 * 方法引用
 * Java 8中方法也是一种对象,可以By名字来引用。不过方法引用的唯一用途是支持
 * Lambda的简写,使用方法名称来表达Lambda。不能通过方法引用来获得诸如方法签名
 * 的相关信息。
 * 方法引用可以通过方法的名字来引用其本身。方法引用是通过::符号(双冒号来描述的。)
 * 它可以用来引用下列类型的方法:
 * 静态方法
 * 实例方法
 * 使用new 操作符的构造方法(TreeSer::new)
 */
public class ReferenceOfNewFeatures {
	public static void main(String args[]){
		List names=new ArrayList();
		names.add("Peter");
		names.add("Linda");
		names.add("Smith");
		names.add("Zack");
		names.add("Bob");
		names.forEach(System.out::println);
	}

}
