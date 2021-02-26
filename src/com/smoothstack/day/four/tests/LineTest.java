package com.smoothstack.day.four.tests;

import com.smoothstack.day.four.Line;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class LineTest {

  @Test
  public void getSlopeTest() {
    Line l1 = new Line(1, 2, 1, 3);
    Assertions.assertThrows(
      ArithmeticException.class,
      () -> {
        l1.getSlope();
      }
    );
    Line l2 = new Line(4, 6, 2, 9);
    Assertions.assertEquals(-1.5, l2.getSlope());
    Line l3 = new Line(9.832, 10.743, 20.432, 34.324);
    Assertions.assertEquals(2.2246226415094, l3.getSlope(), .0001);
  }

  @Test
  public void getDistanceTest() {
    Line l1 = new Line(4, 6, 2, 9);
    Assertions.assertEquals(3.605551275464, l1.getDistance(), .0001);
    Line l2 = new Line(9.832, 10.743, 20.432, 34.324);
    Assertions.assertEquals(25.853888701702, l2.getDistance(), .0001);
  }

  @Test
  public void parallelToTest() {
    Line l1 = new Line(0, 0, 10, 10);
    Line l2 = new Line(2, 2, 12, 12);
    Line l3 = new Line(4, 6, 12, 8);
    Assertions.assertTrue(l1.parallelTo(l2));
    Assertions.assertFalse(l1.parallelTo(l3));
  }
}
