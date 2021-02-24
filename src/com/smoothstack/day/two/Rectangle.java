package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class Rectangle implements Shape {

  private final double length;
  private final double width;

  /**
   * Create a rectangle with the given length and width
   * @param length The length of the rectangle
   * @param width The width of the rectangle
   */
  Rectangle(double length, double width) {
    this.length = length;
    this.width = width;
  }

  /**
   * Calculates the area of a rectangle using L*W
   * @return The area of the rectangle
   */
  @Override
  public double calculateArea() {
    return length * width;
  }

  /**
   * Prints out the rectangle's length, width and area
   */
  @Override
  public void display() {
    System.out.println("Rectangle");
    System.out.println("L: " + length + " W: " + width);
    System.out.println("Area: " + calculateArea());
  }
}
