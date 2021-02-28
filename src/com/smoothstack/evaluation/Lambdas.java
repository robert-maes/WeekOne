package com.smoothstack.evaluation;

import java.util.Scanner;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class Lambdas {

  /**
   * Return whether or not an integer is odd
   * @return A lambda function that determines whether or not an integer is odd
   */
  public static PerformOperation isOdd() {
    // if n % 2 == 0, n is even
    // if n % 2 != 0, n is odd
    return (int n) -> n % 2 != 0;
  }

  /**
   * Return whether or not an integer is prime
   * @return A lambda function that determines whether or not an integer is prime
   */
  public static PerformOperation isPrime() {
    return (int n) -> {
      // loop through all numbers between 1 and n
      // if n is divisible by any of those numbers, n cannot be prime
      for (int i = 2; i < n; i++) {
        if (n % i == 0) {
          return false;
        }
      }
      return true;
    };
  }

  /**
   * Return whether or not an integer is a palindrome
   * @return A lambda function that determines whether or not an integer is a palindrome
   */
  public static PerformOperation isPalindrome() {
    return (int n) -> {
      // create a new StringBuilder
      StringBuilder stringBuilder = new StringBuilder();
      // add n as a string to the builder
      stringBuilder.append(n);
      // reverse the string in the StringBuilder
      stringBuilder.reverse();
      int reverse = 0;
      // attempt to parse an int from the reversed string
      try {
        reverse = Integer.parseInt(stringBuilder.toString());
      } catch (Exception e) {
        return false;
      }
      // if the parsed, reversed int is equal to n, n is a palindrome
      return n == reverse;
    };
  }

  public static void main(String[] args) {
    // set constants for switch statement
    final int IS_ODD = 1;
    final int IS_PRIME = 2;
    final int IS_PALINDROME = 3;

    // initialize the number of test cases
    int numTestCases = 0;
    System.out.println(
      "Please enter the number of tests you wish to perform: "
    );
    Scanner input = new Scanner(System.in);
    // attempt to parse the number of test cases from the user
    // if the number of test cases cannot be parsed, exit with an error
    try {
      numTestCases = input.nextInt();
    } catch (Exception e) {
      System.out.println("Invalid input. Please restart to try again.");
      System.exit(1);
    }
    // flush the input
    input.nextLine();
    // loop through each test case
    for (int i = 0; i < numTestCases; i++) {
      // attempt to extract the op ID and op input for each case
      int operation = 0;
      int number = 0;
      System.out.println("Please enter a test (OPERATION INPUT): ");
      try {
        operation = input.nextInt();
        number = input.nextInt();
      } catch (Exception ex) {
        // exit with an error if unable to parse
        System.out.println("Invalid input. Please restart to try again.");
        System.exit(1);
      }
      // flush the input
      input.nextLine();
      // Perform the correct function based on the operator id and print out the result
      switch (operation) {
        case IS_ODD:
          System.out.println(isOdd().check(number) ? "ODD" : "EVEN");
          break;
        case IS_PRIME:
          System.out.println(isPrime().check(number) ? "PRIME" : "COMPOSITE");
          break;
        case IS_PALINDROME:
          System.out.println(
            isPalindrome().check(number) ? "PALINDROME" : "NOT PALINDROME"
          );
          break;
        default:
          System.out.println("Invalid operator");
          break;
      }
    }
  }
}
