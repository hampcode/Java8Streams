package com.hamp.workshop;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("original list: " + numbers);
		
		
		
//		List<Integer> numbersfilter=filterAllNumbersGreaterThan5AndDividedBy2(numbers);
//		System.out.println("processed list: " + numbersfilter);
		
		List<String> numbersMap=multiplyEachElementBy2UsingLambdaExpression(numbers);
		System.out.println("processed list: " + numbersMap);
		
	}

	// Filter
	public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2(List<Integer> numbers)  {
		
		List<Integer> numbersGreaterThan5AndDividedBy2 = numbers
				.stream()
				.filter(number -> number > 5)
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());

		return numbersGreaterThan5AndDividedBy2;
	}
	
	//Map
	public static List<String>  multiplyEachElementBy2UsingLambdaExpression(List<Integer> numbers) {
	    
	    Function<Integer, Integer> multiplyBy2 = number -> number * 2;
	    Function<Integer, String> transformIntoString = number -> String.valueOf(number);
	 
	    List<String> multipliedNumbersAsString = numbers
	        .stream()
	        .map(multiplyBy2)
	        .map(transformIntoString)
	        .collect(Collectors.toList());
	 
	    return multipliedNumbersAsString;
	
	}


}
