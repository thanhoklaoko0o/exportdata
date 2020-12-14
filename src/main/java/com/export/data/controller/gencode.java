package com.export.data.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Dec 11, 2020	
 *@version 1.0
 */
public class gencode {


	private static Character[] array = new Character[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
			'D', 'E', 'F', 'G', 'H', 'I', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'X', 'Y', 'W', 'Z'

	};

	private static Character[] arrayNumber = new Character[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'

	};

	ArrayList<String> lists = new ArrayList<>();

	public static void main(String[] args) {
//		String test = "001";
//		System.out.println(generate(test));
//		test = "009";
//		System.out.println(generate(test));
//		test = "9A9";
//		System.out.println(generate(test));
//		System.out.println("-------------------");
//		System.out.println(generate("999"));
//		System.out.println("-------------------");
//		System.out.println(generate("99A"));
//		System.out.println("-------------------");
//		System.out.println(generate("99Z"));
		String value = "001";
//		while (true) {
//			
//			System.out.println("-------------------");
//			System.out.println(generate(value));
//			value = generate(value);
//			
//			if (value.equals("ZZZ")) {
//				break;
//			}
//		}
		System.out.println(generate("234"));
		
	}

	public static String generate(String test) {

		try {
			int number = Integer.parseInt(test);
			if (number < 999) {
//				if (number == 99) {
//					return "100";
//				} else {
//					return generateNotNumber(test, arrayNumber);
//				}
//				
				return generateNotNumber(test, arrayNumber);
			}
			return generateNotNumber(test, array);

		} catch (NumberFormatException e) {
//			return generateNotNumber(test);
			return generateNotNumber(test, array);
		}

	}

	private static String generateNotNumber(String test, Character[] characters) {
		char[] charArr = test.toCharArray();
		
		List<Character> list = (List<Character>) Arrays.asList(characters);
		int a = list.indexOf(charArr[2]);
		Character firstCharater = list.indexOf(charArr[2]) == characters.length - 1
				&& list.indexOf(charArr[1]) == characters.length - 1 ? characters[list.indexOf(charArr[0])]
						: charArr[0];
		Character secondCharacter = list.indexOf(charArr[2]) == characters.length - 1
				? list.indexOf(charArr[1]) == characters.length - 1 ? characters[0]
						: characters[list.indexOf(charArr[1]) + 1]
				: charArr[1];
//		System.out.println(list.indexOf(charArr[2]));
		Character thirdCharacter = list.indexOf(charArr[2]) == characters.length - 1 ? characters[0]
				: characters[list.indexOf(charArr[2]) + 1];
		return firstCharater.toString() + secondCharacter.toString() + thirdCharacter.toString();
	}
}
