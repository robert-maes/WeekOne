package com.smoothstack.day.five;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Rob Maes
 * Sat Feb 27 2021
 */
public class CommaSeparatedIntegers {

  public static void main(String[] args) {
    // create a new input scanner and store the line of input as a string
    Scanner input = new Scanner(System.in);
    System.out.println(
      "Please enter a list of comma separated integers, e.x. (3, 44)"
    );
    String inputLine = input.nextLine();
    input.close();
    // split the line of input into an array by the , delimeter
    String[] rawValues = inputLine.split(",");
    // for each string in the array attempt to parse into an int and add into a new int list
    List<Integer> values = new ArrayList<Integer>();
    Arrays
      .stream(rawValues)
      .forEach(
        rawValue -> {
          try {
            int value = Integer.parseInt(rawValue.trim());
            values.add(value);
          } catch (NumberFormatException e) {}
        }
      );
    // for each int in the list check if it is even or odd and print it out
    values
      .stream()
      .forEach(
        n -> {
          if (n % 2 == 0) {
            System.out.print("e" + n + ",");
          } else {
            System.out.print("o" + n + ",");
          }
        }
      );
  }
}
