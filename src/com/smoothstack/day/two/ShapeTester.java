package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class ShapeTester {

  public static void main(String[] args) {
    // Create a rectangle with length 5 and width 10
    Rectangle r = new Rectangle(5, 10);
    // Create a circle with radius 4
    Circle c = new Circle(4);
    // Create a triangle with base 10 and height 3
    Triangle t = new Triangle(10, 3);
    // Print out each shape's dimensions and area
    r.display();
    c.display();
    t.display();
  }
}
