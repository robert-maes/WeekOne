package com.smoothstack.evaluation.tests;

import com.smoothstack.evaluation.Lambdas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rob Maes
 * Fri Feb 26 2021
 */
public class LambdasTest {

  @Test
  public void isOddTest() {
    Assertions.assertTrue(Lambdas.isOdd().check(3));
    Assertions.assertFalse(Lambdas.isOdd().check(2));
  }

  @Test
  public void isPrimeTest() {
    Assertions.assertTrue(Lambdas.isPrime().check(41));
    Assertions.assertFalse(Lambdas.isPrime().check(6));
  }

  @Test
  public void isPalindromeTest() {
    Assertions.assertTrue(Lambdas.isPalindrome().check(1234321));
    Assertions.assertFalse(Lambdas.isPalindrome().check(12345));
  }
}
