package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class Circle implements Shape {

  private final double radius;

  /**
   * Create a circle with the given radius
   * @param radius The radius of the circle
   */
  Circle(double radius) {
    this.radius = radius;
  }

  /**
   * Calculates the area of a circle using PI*r^2
   * @return The area of the circle
   */
  @Override
  public double calculateArea() {
    return Math.pow(radius, 2) * Math.PI;
  }

  /**
   * Prints out the circle's radius, diameter and area
   */
  @Override
  public void display() {
    System.out.println("Circle");
    System.out.println("R: " + radius + " D: " + (radius * 2));
    System.out.println("Area: " + calculateArea());
  }
}
