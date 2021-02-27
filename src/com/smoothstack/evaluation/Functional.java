package com.smoothstack.evaluation;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class Functional {

  /**
   * Takes an integer array and returns a new integer array containing only the right-most digit for each int
   */
  public static Function<Integer[], Integer[]> rightDigit = value -> {
    // create a new integer array of the same size
    Integer[] temp = new Integer[value.length];
    // loop through the existing array
    for (int i = 0; i < value.length; i++) {
      // assign n in the new array to n % 10 (right-most digit)
      temp[i] = value[i] % 10;
    }
    return temp;
  };

  /**
   * Takes an integer array and returns a new integer array containing each original int doubled
   */
  public static Function<Integer[], Integer[]> doubling = value -> {
    // create a new integer array of the same size
    Integer[] temp = new Integer[value.length];
    // loop through the existing array
    for (int i = 0; i < value.length; i++) {
      // assign n in the new array to n * 2 (doubled)
      temp[i] = value[i] * 2;
    }
    return temp;
  };

  /**
   * Takes a string array and returns a new string array containing each string with all 'x' characters removed
   */
  public static Function<String[], String[]> noX = value -> {
    // create a new string array of the same size
    String[] temp = new String[value.length];
    // loop through the existing array
    for (int i = 0; i < value.length; i++) {
      // assign s in the new array to s with all 'x' chars removed
      temp[i] = value[i].replace("x", "");
    }
    return temp;
  };
}
