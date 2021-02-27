package com.smoothstack.day.five;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Rob Maes
 * Sat Feb 27 2021
 */
public class FilterStringList {

  /**
   * Given a list of strings, removes all entries that are not exactly 3 chars in length and begin with 'a'
   * @param input A list of strings to filter
   * @return A new list of strings containing only entries exactly 3 chars in length beginning with 'a'
   */
  public static List<String> threeLettersStartWithA(List<String> input) {
    return input
      .stream()
      .filter(s -> s.charAt(0) == 'a' && s.length() == 3)
      .collect(Collectors.toList());
  }
}
