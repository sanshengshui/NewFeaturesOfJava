package com.shiyanlou.java8;
/*
 * @author jamesmsw
 * @time  2017-2-28
 * @annotation
 * 一个Lambda表达式具有下面这样的语法特征。它由三个部分组成:第一部分为一个括号内用逗号分隔的形参，参数即
 * 函数式接口里面方法的参数；第二部分为一个箭头符号: ->; 第三部分为方法体，可以是方法体或代码块。语法如下:
 * parameter -> expression body
 * 下面列举了Lambda表达式的几个最重要的特性:
 * 可选的类型声明:你不用去声明参数的类型。编译器可以从参数的值来推断它是什么类型。
 * 可选的参数周围的括号:你可以不用在括号内声明单个参数。但是对于很多参数的情况，括号是必需的。
 * 可选的大括号:如果表达式体里面只有一个语句,那么你不必用大括号括起来。
 * 可选的返回关键字:如果表达式体只有单个表达式用于值的返回,那么编译器会自动完成这一步。若要指示表达式来返回某个值，
 * 则需要使用大括号。
 * 
 * 函数式接口的重要属性是:我们能够使用Lambda实例化它们,Lambda表达式让你能够将函数作为方法参数，或者将代码
 * 作为数据对待。Lambda表达式的引用给开发者带来了不少优点:在Java8之前,匿名内部类,监听器和事件处理器的使用都
 * 显得很很长，代码可读性很差，Lambda表达式的应用则使代码变得更加紧凑，可读性增强;Lambda表达式使并行操作
 * 大集合变得很方便,可以充分发挥多核CPU的优势，更易于为多核处理器编写代码。
 */

public class NewFeaturesTester {
	public static void main(String[] args){
		NewFeaturesTester tester=new NewFeaturesTester();
		
		//带有类型申明的表达式
		MathOperation addition=(int a,int b)-> a+ b;
		//没有类型声明的表达式
		MathOperation subtraction=(a,b)->a-b;
		//带有大括号,带有返回语句的表达式
		MathOperation multiplication=(int a,int b)->{return a * b;};
		//带有大括号和return语句的表达式
		MathOperation division=(int a,int b)->a/b;
		
		//输出结果
		System.out.println("10 + 5 = "+ tester.operate(100, 2, addition));
		System.out.println("10 - 5 = " +tester.operate(100, 2, subtraction));
		System.out.println("10 * 5 = " +tester.operate(100, 2, multiplication));
		System.out.println("10 / 5 = "+tester.operate(100, 2, division));
		
		//没有括号的表达式
		GreetingService greetService1=message->
		System.out.println("Hello "+message);
		//有括号的表达式
		GreetingService greetService2=(message)->
		System.out.println("Hello "+message);
		//调用sayMessage方法输出结果
		greetService1.sayMessage("shiyanlou");
		greetService2.sayMessage("Classmate");
	}

	//下面是定义的一些接口和方法
	interface MathOperation{
		int operation(int a,int b);
	}
	interface GreetingService{
		void sayMessage(String message);
	}
	private int operate(int a,int b,MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}
}
