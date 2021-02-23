/**
 * Mon Feb 22 2021
 */
package com.smoothstack.day.one;

/**
 * @author Rob Maes
 *
 */
public class Patterns {

	public static void main(String[] args) {
		// Pattern 1
		System.out.println("1)");
		printStairs('*', 4);
		printChar('.', 9);
		System.out.println();
		
		// Pattern 2
		System.out.println("2)");
		printChar('.', 10);
		printInvertedStairs('*', 4);
		System.out.println();
		
		// Pattern 3
		System.out.println("3)");
		printPyramid('*', 4);
		printChar('.', 11);
		System.out.println();
		
		// Pattern 4
		System.out.println("4)");
		printChar('.', 12);
		printInvertedPyramid('*', 4);
	}
	
	/**
	 * Prints a stair-step pattern n levels deep
	 * @param character The character to print
	 * @param levels The number of levels for the pattern
	 */
	private static void printStairs(char character, int levels) {
		for(int i = 0; i < levels; i++) {
			for(int j = 0; j <= i; j++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints an inverted stair-step pattern n levels deep
	 * @param character The character to print
	 * @param levels The number of levels for the pattern
	 */
	private static void printInvertedStairs(char character, int levels) {
		for(int i = levels; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints a pyramid pattern n levels deep
	 * @param character The character to print
	 * @param levels The number of levels for the pyramid
	 */
	private static void printPyramid(char character, int levels) {
		int spaces = levels + 1;
		for (int i = 1; i <= levels; i++) {
			for(int j = 0; j < spaces; j++) {
				System.out.print(" ");
			}
			spaces--;
			int characterCount = i * 2 - 1;
			for(int k = 0; k < characterCount; k++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints an inverted pyramid pattern n levels deep
	 * @param character The character to print
	 * @param levels The number of levels for the pyramid
	 */
	private static void printInvertedPyramid(char character, int levels) {
		int spaces = 2;
		for (int i = levels; i > 0; i--) {
			for(int j = 0; j < spaces; j++) {
				System.out.print(" ");
			}
			spaces++;
			int characterCount = i * 2 - 1;
			for(int k = 0; k < characterCount; k++) {
				System.out.print(character);
			}
			System.out.println();
		}
	}
	
	/**
	 * Prints a single line of character n times
	 * @param character The character to print
	 * @param numTimes The number of times to print the character
	 */
	private static void printChar(char character, int numTimes) {
		for(int i = 0; i < numTimes; i++) {
			System.out.print(character);
		}
		System.out.println();
	}

}
