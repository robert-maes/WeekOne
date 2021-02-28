package com.smoothstack.evaluation;

import java.util.Arrays;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class Functional {

  /**
   * Takes an integer array and returns a new integer array containing only the right-most digit for each int
   * @param nums An array of integers
   * @return A new array of integers containing only the right-most digit for each int
   */
  public static int[] rightDigit(int[] nums) {
    return Arrays.stream(nums).map(num -> num % 10).toArray();
  }

  /**
   * Takes an integer array and returns a new integer array containing each original int doubled
   * @param nums An array of integers
   * @return A new array of integers with the value of each int doubled
   */
  public static int[] doubling(int[] nums) {
    return Arrays.stream(nums).map(num -> num * 2).toArray();
  }

  /**
   * Takes a string array and returns a new string array containing each string with all 'x' characters removed
   * @param strings An array of strings
   * @return A new array of strings with all 'x' characters removed
   */
  public static String[] noX(String[] strings) {
    return Arrays
      .stream(strings)
      .map(str -> str.replace("x", ""))
      .toArray(String[]::new);
  }
}
