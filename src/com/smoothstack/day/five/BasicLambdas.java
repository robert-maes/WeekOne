package com.smoothstack.day.five;

import java.util.Arrays;
import java.util.List;

/**
 * @author Rob Maes
 * Sat Feb 27 2021
 */
public class BasicLambdas {

  /**
   * Compare strings with strings containing 'e' coming first
   * @param n1 string 1
   * @param n2 string 2
   * @return 0 if both contain 'e', -1 if string 1 contains 'e', 1 if string 2 contains 'e'
   */
  public static int eFirst(String n1, String n2) {
    boolean n1ContainsE = n1.contains("e");
    boolean n2ContainsE = n2.contains("e");
    if (n1ContainsE && n2ContainsE) {
      return 0;
    } else if (n1ContainsE && !n2ContainsE) {
      return -1;
    } else {
      return 1;
    }
  }

  public static void main(String[] args) {
    // Create a list of names
    List<String> names = Arrays.asList(
      "James",
      "John",
      "Robert",
      "Michael",
      "William",
      "David",
      "Richard",
      "Joseph",
      "Thomas",
      "Charles",
      "Mary",
      "Patricia",
      "Jennifer",
      "Linda",
      "Elizabeth",
      "Barbara",
      "Susan",
      "Jessica",
      "Sarah",
      "Karen"
    );

    System.out.println("\nShortest to longest");
    System.out.println("-------------------");
    // sort the names from shortest to longest
    names
      .stream()
      .sorted((n1, n2) -> n1.length() - n2.length())
      .forEach(System.out::println);

    System.out.println("\nLongest to shortest");
    System.out.println("-------------------");
    // sort the names from longest to shortest
    names
      .stream()
      .sorted((n1, n2) -> n2.length() - n1.length())
      .forEach(System.out::println);

    System.out.println("\nAlphabetically by first character only");
    System.out.println("----------------------------------------");
    // sort the names alphabetically with respect only to the first character
    names
      .stream()
      .sorted((n1, n2) -> n1.charAt(0) - n2.charAt(0))
      .forEach(System.out::println);

    System.out.println(
      "\nStrings that contain 'e' first, everything else second"
    );
    System.out.println(
      "--------------------------------------------------------"
    );
    // sort the names placing names containing an 'e' above those that do not
    names
      .stream()
      .sorted(
        (n1, n2) -> {
          boolean n1ContainsE = n1.contains("e");
          boolean n2ContainsE = n2.contains("e");
          if (n1ContainsE && n2ContainsE) {
            return 0;
          } else if (n1ContainsE && !n2ContainsE) {
            return -1;
          } else {
            return 1;
          }
        }
      )
      .forEach(System.out::println);

    System.out.println("\nPrevious problem with static helper method");
    System.out.println("--------------------------------------------");
    // create a new array from the previous List
    String[] names2 = new String[names.size()];
    names.toArray(names2);
    // sort the names placing names containing 'e' above those that do not
    Arrays.sort(names2, (n1, n2) -> eFirst(n1, n2));
    // print out the sorted array
    Arrays.stream(names2).forEach(System.out::println);
  }
}
