package com.smoothstack.evaluation.tests;

import static com.smoothstack.evaluation.Recursion.groupSumClump;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class RecursionTest {

  @Test
  public void groupSumClumpTest() {
    Assertions.assertTrue(groupSumClump(0, new int[] { 2, 4, 8 }, 10));
    Assertions.assertTrue(groupSumClump(0, new int[] { 1, 2, 4, 8, 1 }, 14));
    Assertions.assertFalse(groupSumClump(0, new int[] { 2, 4, 4, 8 }, 14));
  }
}
