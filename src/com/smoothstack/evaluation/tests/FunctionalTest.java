package com.smoothstack.evaluation.tests;

import static com.smoothstack.evaluation.Functional.doubling;
import static com.smoothstack.evaluation.Functional.noX;
import static com.smoothstack.evaluation.Functional.rightDigit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class FunctionalTest {

  @Test
  public void rightDigitTest() {
    int[] input = { 1, 2, 3 };
    // test that rightDigit works
    Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, rightDigit(input));
    // test that the original input is unmodified
    Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, input);
    int[] input2 = { 16, 8, 886, 8, 1 };
    Assertions.assertArrayEquals(
      new int[] { 6, 8, 6, 8, 1 },
      rightDigit(input2)
    );
    Assertions.assertArrayEquals(new int[] { 16, 8, 886, 8, 1 }, input2);
    int[] input3 = { 10, 0 };
    Assertions.assertArrayEquals(new int[] { 0, 0 }, rightDigit(input3));
    Assertions.assertArrayEquals(new int[] { 10, 0 }, input3);
  }

  @Test
  public void doublingTest() {
    int[] input = { 1, 2, 3 };
    // test that doubling works
    Assertions.assertArrayEquals(new int[] { 2, 4, 6 }, doubling(input));
    // test that the original input is unmodified
    Assertions.assertArrayEquals(new int[] { 1, 2, 3 }, input);
    int[] input2 = { 6, 8, 6, 8, -1 };
    Assertions.assertArrayEquals(
      new int[] { 12, 16, 12, 16, -2 },
      doubling(input2)
    );
    Assertions.assertArrayEquals(new int[] { 6, 8, 6, 8, -1 }, input2);
    int[] input3 = {};
    Assertions.assertArrayEquals(new int[] {}, doubling(input3));
    Assertions.assertArrayEquals(new int[] {}, input3);
  }

  @Test
  public void noXTest() {
    String[] input = { "ax", "bb", "cx" };
    // test that noX works
    Assertions.assertArrayEquals(new String[] { "a", "bb", "c" }, noX(input));
    // test that the original input is unmodified
    Assertions.assertArrayEquals(new String[] { "ax", "bb", "cx" }, input);
    String[] input2 = { "xxax", "xbxbx", "xxcx" };
    Assertions.assertArrayEquals(new String[] { "a", "bb", "c" }, noX(input2));
    Assertions.assertArrayEquals(
      new String[] { "xxax", "xbxbx", "xxcx" },
      input2
    );
    String[] input3 = { "x" };
    Assertions.assertArrayEquals(new String[] { "" }, noX(input3));
    Assertions.assertArrayEquals(new String[] { "x" }, input3);
  }
}
