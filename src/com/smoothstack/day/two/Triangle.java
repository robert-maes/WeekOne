package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class Triangle implements Shape {

  private final double base;
  private final double height;

  /**
   * Creates a new triangle with the given base and height
   * @param base The base size of the triangle
   * @param height The height of the triangle
   */
  Triangle(double base, double height) {
    this.base = base;
    this.height = height;
  }

  /**
   * Calculates the area of a triangle using 1/2*B*H
   * @return The area of the triangle
   */
  @Override
  public double calculateArea() {
    return 0.5 * base * height;
  }

  /**
   * Prints out the triangle's base, height and area
   */
  @Override
  public void display() {
    System.out.println("Triangle");
    System.out.println("B: " + base + " H: " + height);
    System.out.println("Area: " + calculateArea());
  }
}
