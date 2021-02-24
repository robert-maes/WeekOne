package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class Sum {

  public static void main(String[] args) {
    // initialize sum to 0
    double sum = 0.0;

    // loop through each argument
    for (String arg : args) {
      /*
      Attempt to parse each argument as a double
      If valid, add parsed number to sum
      If invalid, skip it
       */
      double number = 0.0;
      try {
        number = Double.parseDouble(arg);
      } catch (NumberFormatException e) {
        number = 0.0;
      }
      sum += number;
    }

    // print the sum
    System.out.println("The sum is: " + sum);
  }
}
