package com.shiyanlou.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/*
 * Java 8引入了Stream(流式操作),你可以通过该操作实现对集合的并行处理和函数式操作。
 * Collection是一种静态的内存数据结构，而Stream是面向计算的。
 * 
 *　Streams(流)
 * Stream是Java８中的一个新的抽象层。通过使用Strea,你能以类似于SQL语句的声明式方式处理数据。
 * 例如一个典型的SQL语句能够自动地返回某些信息，而不用在开发者这一端做任何的计算工作。同样，通过使用
 * Java的集合框架，开发者能够利用循环做重复的检查。另外一个关注点是效率，就像多核处理器能够提升效率一样，
 * 开发者也可以通过并行化编程来改进工作流程，但是这样很容易出错。
 * 
 * 因此，Stream的引入是为了解决上述痛点。开发者可以通过声明式数据，以及简单地利用多核处理体系而不用写
 * 特定的代码。
 * Stream是什么?Stream代表了来自某个源的对象的序列，这些序列支持聚集操作。
 * 
 * 什么是聚合操作
 * 在传统的J2EE应用中,Java代码经常不得不依赖关系型数据库的聚合操作来完成诸如:
 * 客户每月平均消费金额
 * 最昂贵的在售商品
 * 本周完成的有效订单(排除了无效的)
 * 取十个数据样本作为首页推荐
 * 这类的操作。
 * 但在当今这个数据大爆炸的时代，在数据来源多样化，数据海量化的今天,很多时候不得不脱离RDBMS,或者以底层返回的数据
 * 为基础进行更上层的数据统计。而 Java 的集合 API 中，仅仅有极少量的辅助型方法，更多的时候是程序员需要用 Iterator 
 * 来遍历集合，完成相关的聚合应用逻辑。这是一种远不够高效、笨拙的方法。在 Java 7 中，
 * 如果要发现 type 为 grocery 的所有交易，然后返回以交易值降序排序好的交易 ID 集合，我们需要这样写：
 * 
 * 推荐看这篇文章
 * https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/
 */

public class StreamOfNewFeatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Using Java 7: ");
		
		// 统计空字符串的数量
	      List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
	      System.out.println("List: " +strings);
	      long count = getCountEmptyStringUsingJava7(strings);

	      System.out.println("Empty Strings: " + count);
	      count = getCountLength3UsingJava7(strings);

	      System.out.println("Strings of length 3: " + count);

	      // 消除空字符串
	      List<String> filtered = deleteEmptyStringsUsingJava7(strings);
	      System.out.println("Filtered List: " + filtered);

	      // 消除空字符串，同时使用逗号来连接
	      String mergedString = getMergedStringUsingJava7(strings,", ");
	      System.out.println("Merged String: " + mergedString);
	      List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);

	      // 获得不同数字的平方的列表
	      List<Integer> squaresList = getSquares(numbers);
	      System.out.println("Squares List: " + squaresList);
	      List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);

	      System.out.println("List: " +integers);
	      System.out.println("Highest number in List : " + getMax(integers));
	      System.out.println("Lowest number in List : " + getMin(integers));
	      System.out.println("Sum of all numbers : " + getSum(integers));
	      System.out.println("Average of all numbers : " + getAverage(integers));


	      // 输出10个随机数
	      System.out.println("Random Numbers: ");
	      Random random = new Random();

	      for(int i=0; i < 10; i++){
	         System.out.println(random.nextInt());
	      }

	      //使用Java 8的新特性
	      System.out.println("Using Java 8: ");
	      System.out.println("List: "+strings);
	      
	      count=strings.stream().filter(string->string.isEmpty()).count();
	      System.out.println("Empty String: "+count);
	      
	      count=strings.stream().filter(string ->string.length()==3).count();
	      System.out.println("Strings of length 3:"+count);
	      
	      filtered=strings.stream().filter(string->!string.isEmpty()).collect(Collectors.toList());
	      System.out.println("Filtered List: "+filtered);
	      mergedString = strings.stream().filter(string ->!string.isEmpty()).collect(Collectors.joining(", "));
	      System.out.println("Merged String: " + mergedString);

	      squaresList = numbers.stream().map( i ->i*i).distinct().collect(Collectors.toList());
	      System.out.println("Squares List: " + squaresList);
	      System.out.println("List: " +integers);

	      IntSummaryStatistics stats = integers.stream().mapToInt((x) ->x).summaryStatistics();
	      
	      // 输出结果
	      System.out.println("Highest number in List : " + stats.getMax());
	      System.out.println("Lowest number in List : " + stats.getMin());
	      System.out.println("Sum of all numbers : " + stats.getSum());
	      System.out.println("Average of all numbers : " + stats.getAverage());
	      System.out.println("Random Numbers: ");

	      random.ints().limit(10).sorted().forEach(System.out::println);

	      // 并行处理
	      count = strings.parallelStream().filter(string -> string.isEmpty()).count();
	      System.out.println("Empty Strings: " + count);


	}
	//使用Java 7版本就提供的API来计算空串数量
	private static int getCountEmptyStringUsingJava7(List<String> strings){
		int count=0;
		for(String string:strings){
			if(string.isEmpty()){
				count++;
			}
		}
		return count;
	}
	// 使用Java 7版本就提供的API来计算长度为3字符的字符串数量
	   private static int getCountLength3UsingJava7(List<String> strings){
	      int count = 0;

	      for(String string: strings){

	         if(string.length() == 3){
	            count++;
	         }
	      }
	      return count;
	   }

	   // 使用Java 7版本就提供的API来删除空串
	   private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
	      List<String> filteredList = new ArrayList<String>();

	      for(String string: strings){

	         if(!string.isEmpty()){
	             filteredList.add(string);
	         }
	      }
	      return filteredList;
	   }

	   // 使用Java 7版本就提供的API来获取合并后的字符串
	   private static String getMergedStringUsingJava7(List<String> strings, String separator){
	      StringBuilder stringBuilder = new StringBuilder();

	      for(String string: strings){

	         if(!string.isEmpty()){
	            stringBuilder.append(string);
	            stringBuilder.append(separator);
	         }
	      }
	      String mergedString = stringBuilder.toString();
	      return mergedString.substring(0, mergedString.length()-2);
	   }


	   // 自定义的用于计算数字的平方的方法
	   private static List<Integer> getSquares(List<Integer> numbers){
	      List<Integer> squaresList = new ArrayList<Integer>();

	      for(Integer number: numbers){
	         Integer square = new Integer(number.intValue() * number.intValue());

	         if(!squaresList.contains(square)){
	            squaresList.add(square);
	         }
	      }
	      return squaresList;
	   }

	   // 自定义的用于获得List中最大值的方法
	   private static int getMax(List<Integer> numbers){
	      int max = numbers.get(0);

	      for(int i=1;i < numbers.size();i++){

	         Integer number = numbers.get(i);

	         if(number.intValue() > max){
	            max = number.intValue();
	         }
	      }
	      return max;
	   }

	   // 自定义的用于获得List中最小值的方法
	   private static int getMin(List<Integer> numbers){
	      int min = numbers.get(0);

	      for(int i=1;i < numbers.size();i++){
	         Integer number = numbers.get(i);

	         if(number.intValue() < min){
	            min = number.intValue();
	         }
	      }
	      return min;
	   }

	   // 自定义的用于获得List中各个数字的和的方法
	   private static int getSum(List<Integer> numbers){
	      int sum = (int)(numbers.get(0));

	      for(int i=1;i < numbers.size();i++){
	         sum += (int)numbers.get(i);
	      }
	      return sum;
	   }

	   // 自定义的用于获得List中各个数字的平均值的方法
	   private static int getAverage(List<Integer> numbers){
	      return getSum(numbers) / numbers.size();
	   }

}
