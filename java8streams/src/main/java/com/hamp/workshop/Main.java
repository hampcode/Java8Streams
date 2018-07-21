package com.hamp.workshop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("original numbers list: " + numbers);
		
//		List<String> listOfWords = Arrays.asList("B", "A", "D", "E", "C");
//		System.out.println("original words list: " + listOfWords);
		
		//filter(Predicate)
//		List<Integer> numbersfilter=filterAllNumbersGreaterThan5AndDividedBy2(numbers);
//		System.out.println("processed numbers list: " + numbersfilter);
		
		
		//map(Function)
//		List<String> numbersMap=multiplyEachElementBy2UsingLambdaExpression(numbers);
//		System.out.println("processed numbers list: " + numbersMap);
		
		
		//sorted(Comparator)
//		List<String> wordsSorted=sortTheList(listOfWords);
//		System.out.println("processed words list: " + wordsSorted);
		
//		List<String> wordsSortedWithInversedComparator=sortTheListWithInversedComparator(listOfWords);
//		System.out.println("processed words list inversed: " + wordsSortedWithInversedComparator);
		
		//match(Predicate)
//		boolean numbersNumberGreaterThan4=checkIfThereIsANumberGreaterThan4(numbers);
//		System.out.println("processed list: " + numbersNumberGreaterThan4);
//		
//		boolean numbersNumberIsPair=checkIfEachNumberIsPair(numbers);
//		System.out.println("processed list: " + numbersNumberIsPair);
//		
//		boolean numbersNumberIsNotPair=checkIfEachNumberIsNotPair(numbers);
//		System.out.println("processed list: " + numbersNumberIsNotPair);
		
		
		//limit(long n)/skip(long n)
		List<Integer> limitNumbers=getLimitNumbers(numbers);
		System.out.println("processed numbers list: " + limitNumbers);
		
		List<Integer> skipNumbers=getSkipNumbers(numbers);
		System.out.println("processed numbers list: " + skipNumbers);
		
		
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
	
	//match(Predicate)
	public static boolean checkIfThereIsANumberGreaterThan4(List<Integer> numbers)  {
	    
	 
	    boolean anyNumberGreaterThan4 = numbers
	        .stream()
	        .anyMatch(number -> number > 4);
	 
	    return anyNumberGreaterThan4;
	}
	
	public static boolean checkIfEachNumberIsPair(List<Integer> numbers)  {
	 
	 
	    boolean eachNumberIsPair = numbers
	        .stream()
	        .allMatch(number -> number % 2 == 0);
	 
	    return eachNumberIsPair;
	}

	public static boolean checkIfEachNumberIsNotPair(List<Integer> numbers)  {
	    
	    boolean eachNumberIsNotPair = numbers
	        .stream()
	        .noneMatch(number -> number % 2 == 0);
	 
	    return eachNumberIsNotPair;
	}

	//limit(long n)/skip(long n)
	public static List<Integer> getLimitNumbers(List<Integer> numbers)  {
	    
		List<Integer> numberLimit = numbers
				.stream()
				.limit(3)
				.collect(Collectors.toList());

	 
	    return numberLimit;
	}

	
	public static List<Integer> getSkipNumbers(List<Integer> numbers)  {
	    
		List<Integer> numberSkip = numbers
				.stream()
				.skip(3)
				.collect(Collectors.toList());
	 
	    return numberSkip;
	}

}
