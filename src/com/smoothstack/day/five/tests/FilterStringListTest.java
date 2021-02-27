package com.smoothstack.day.five.tests;

import static com.smoothstack.day.five.FilterStringList.threeLettersStartWithA;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rob Maes
 * Sat Feb 27 2021
 */
public class FilterStringListTest {

  @Test
  public void threeLettersStartWithATest() {
    List<String> expected = Arrays.asList("add", "art");
    List<String> input = Arrays.asList(
      "add",
      "sub",
      "John",
      "allowance",
      "art"
    );
    Assertions.assertArrayEquals(
      expected.toArray(),
      threeLettersStartWithA(input).toArray()
    );
  }
}
