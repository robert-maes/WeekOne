package com.smoothstack.day.two;

/**
 * @author Rob Maes
 * Tue Feb 23 2021
 */
public class Max2D {

  public static void main(String[] args) {
    // construct a 2D array of numbers
    final int[][] numArray = {
      { 1, 2, 3 },
      { 5, 22, 7 },
      { 9, 10, 11, 12 },
      { 13, 14, 15, 16 },
    };

    // initialize placeholders
    final int rows = numArray.length;
    int maxNum = 0;
    int posX = 0;
    int posY = 0;

    // loop through each element in the outer array
    for (int i = 0; i < rows; i++) {
      // loop through each element in the inner array
      for (int j = 0; j < numArray[i].length; j++) {
        /*
        If the current number is greater than the current max,
        Set the max to the current number along with its position
         */
        final int numValue = numArray[i][j];
        if (numValue > maxNum) {
          maxNum = numValue;
          posX = i;
          posY = j;
        }
      }
    }

    // Print the max number and its position
    System.out.println(
      "The max number is " + maxNum + " at [" + posX + "][" + posY + "]"
    );
  }
}
