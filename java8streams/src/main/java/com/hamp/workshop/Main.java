package com.hamp.workshop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
//		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		System.out.println("original numbers list: " + numbers);
		
		List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");
		System.out.println("original words list: " + listOfWords);
		
		
//		List<Integer> numbersfilter=filterAllNumbersGreaterThan5AndDividedBy2(numbers);
//		System.out.println("processed numbers list: " + numbersfilter);
		
//		List<String> numbersMap=multiplyEachElementBy2UsingLambdaExpression(numbers);
//		System.out.println("processed numbers list: " + numbersMap);
		
//		List<String> wordsSorted=sortTheList(listOfWords);
//		System.out.println("processed words list: " + wordsSorted);
		
		List<String> wordsSortedWithInversedComparator=sortTheListWithInversedComparator(listOfWords);
		System.out.println("processed words list inversed: " + wordsSortedWithInversedComparator);
		
	}

	//filter(Predicate)
	public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2(List<Integer> numbers)  {
		
		List<Integer> numbersGreaterThan5AndDividedBy2 = numbers
				.stream()
				.filter(number -> number > 5)
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());

		return numbersGreaterThan5AndDividedBy2;
	}
	
	//map(Function)
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
	
	//sorted(Comparator)
	public static List<String> sortTheList(List<String> listOfWords)  {
	    
	    List<String> sortedList = listOfWords
	        .stream()
	        .sorted()
	        .collect(Collectors.toList());
	 
	    return sortedList;
	}
	
	public static List<String> sortTheListWithInversedComparator(List<String> listOfWords)  {
	    
	    Comparator<String> inversed = (String o1, String o2) -> o2.compareTo(o1);
	 
	    List<String> sortedList = listOfWords
	        .stream()
	        .sorted(inversed)
	        .collect(Collectors.toList());
	 
	    return sortedList;
	}


}
