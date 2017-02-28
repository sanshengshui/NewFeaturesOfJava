package com.shiyanlou.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * ＠函数式接口
 * 函数式接口有一个单一的功能来表现。例如,带有单个compareTo方法的比较接口,被用于比较的场合。
 * Java８定义了大量的函数式接口来广泛地用于lambda表达式。
 * 
 * Java 8引入的一个核心概念是函数式接口，通过在接口里面添加一个抽象方法,这些方法可以直接
 * 从接口中运行。如果一个接口定义个唯一一个抽象方法，那么这个接口就成为函数式接口。同时，引入一个新
 * 的注解：＠Functionalinterface。可以把他它放在一个接口前，表示这个接口是一个函数式接口。
 * 这个注解是非必须的，只要接口只包含一个方法的接口，虚拟机会自动判断，不过最好在接口上使用
 * 注解＠Functionalinterface进行声明。在接口中添加了@Functionalinterface的接口，
 * 只允许有一个抽象方法，否则编译器也会出错。
 * 下面是部分函数式接口的列表。

BitConsumer<T,U>：该接口代表了接收两个输入参数T、U，并且没有返回的操作。
BiFunction<T,U,R>：该接口代表提供接收两个参数T、U，并且产生一个结果R的方法。
BinaryOperator<T>：代表了基于两个相同类型的操作数，产生仍然是相同类型结果的操作。
BiPredicate<T,U>：代表了对两个参数的断言操作（基于Boolean值的方法）。
BooleanSupplier：代表了一个给出Boolean值结果的方法。
Consumer<T>：代表了接受单一输入参数并且没有返回值的操作。
DoubleBinaryOperator：代表了基于两个Double类型操作数的操作，并且返回一个Double类型的返回值。
DoubleConsumer：代表了一个接受单个Double类型的参数并且没有返回的操作。
DoubleFunction<R>：代表了一个接受Double类型参数并且返回结果的方法。
DoublePredicate：代表了对一个Double类型的参数的断言操作。
DoubleSupplier：代表了一个给出Double类型值的方法。
DoubleToIntFunction：代表了接受单个Double类型参数但返回Int类型结果的方法。
DoubleToLongFunction：代表了接受单个Double类型参数但返回Long类型结果的方法。
DoubleUnaryOperator：代表了基于单个Double类型操作数且产生Double类型结果的操作。
Function<T,R>：代表了接受一个参数并且产生一个结果的方法。
IntBinaryOperator：代表了对两个Int类型操作数的操作，并且产生一个Int类型的结果。
IntConsumer：代表了接受单个Int类型参数的操作，没有返回结果。
IntFunction<R>：代表了接受Int类型参数并且给出返回值的方法。
IntPredicate：代表了对单个Int类型参数的断言操作。
 * 
 * 
 * 
 * 
 * 
 */

public class FuncInterOfNewFeatures {
	public static void main(String[] args){
		List<Integer> list=Arrays.asList(0,1,2,3,4,5,6,7,8,9);
		System.out.println("All of the numbers:");
		eval(list,n->true);
		System.out.println("Even numbers:");
		eval(list,n->n%2 ==0);
		System.out.println("Numbers that greater than 5:");
		eval(list,n->n>5);
		
	}
	
	public static void eval(List<Integer> list,Predicate<Integer> predicate){
		for(Integer n:list){
			if(predicate.test(n)){
				System.out.println(n + " ");
			}
		}
		
		
		
	}

}
