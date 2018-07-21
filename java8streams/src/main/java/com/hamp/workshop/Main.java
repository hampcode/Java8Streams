package com.hamp.workshop;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		filterAllNumbersGreaterThan5AndDividedBy2().forEach(System.out::println);
	}

	// Filter
	public static List<Integer> filterAllNumbersGreaterThan5AndDividedBy2()  {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		List<Integer> numbersGreaterThan5AndDividedBy2 = numbers
				.stream()
				.filter(number -> number > 5)
				.filter(number -> number % 2 == 0)
				.collect(Collectors.toList());

		return numbersGreaterThan5AndDividedBy2;
	}


}
