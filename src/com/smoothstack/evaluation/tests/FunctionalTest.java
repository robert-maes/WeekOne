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
    Assertions.assertArrayEquals(
      new Integer[] { 1, 2, 3 },
      rightDigit.apply(new Integer[] { 1, 22, 93 })
    );
    Assertions.assertArrayEquals(
      new Integer[] { 6, 8, 6, 8, 1 },
      rightDigit.apply(new Integer[] { 16, 8, 886, 8, 1 })
    );
    Assertions.assertArrayEquals(
      new Integer[] { 0, 0 },
      rightDigit.apply(new Integer[] { 10, 0 })
    );
  }

  @Test
  public void doublingTest() {
    Assertions.assertArrayEquals(
      new Integer[] { 2, 4, 6 },
      doubling.apply(new Integer[] { 1, 2, 3 })
    );
    Assertions.assertArrayEquals(
      new Integer[] { 2, 4, 6 },
      doubling.apply(new Integer[] { 1, 2, 3 })
    );
    Assertions.assertArrayEquals(
      new Integer[] { 12, 16, 12, 16, -2 },
      doubling.apply(new Integer[] { 6, 8, 6, 8, -1 })
    );
    Assertions.assertArrayEquals(
      new Integer[] {},
      doubling.apply(new Integer[] {})
    );
  }

  @Test
  public void noXTest() {
    Assertions.assertArrayEquals(
      new String[] { "a", "bb", "c" },
      noX.apply(new String[] { "ax", "bb", "cx" })
    );
    Assertions.assertArrayEquals(
      new String[] { "a", "bb", "c" },
      noX.apply(new String[] { "xxax", "xbxbx", "xxcx" })
    );
    Assertions.assertArrayEquals(
      new String[] { "" },
      noX.apply(new String[] { "x" })
    );
  }
}
