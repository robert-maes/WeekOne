package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public interface Shape {
  /**
   * Calculates the area of any shape
   * @return The shape's area as a double
   */
  public double calculateArea();

  /**
   * Prints out the shape's dimensions and area
   */
  public void display();
}
