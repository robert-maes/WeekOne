/**
 * Mon Feb 22 2021
 */
package com.smoothstack.day.one;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Rob Maes
 *
 */
public class GuessingGame {

  public static void main(String[] args) {
    // calculate a random number and a range of +- 10
    final int randomNumber = (int) ((Math.random() * (100 - 1)) + 1);
    final int bottomRange = randomNumber - 10;
    final int topRange = randomNumber + 10;

    // the number of guesses the user has made
    int guesses = 0;
    Scanner inputScanner = new Scanner(System.in);

    // give the user 5 tries to guess
    while (guesses < 5) {
      Integer guess = null;

      // keep prompting the user to enter a guess until it is valid (an integer between 1-100)
      while (guess == null) {
        System.out.print(
          "[Guess " +
          (guesses + 1) +
          " of 5] What do you think the number is? (between 1-100): "
        );
        // ensure they enter an integer
        try {
          guess = inputScanner.nextInt();
        } catch (InputMismatchException e) {
          System.out.println("Error: You must guess a number");
          inputScanner.nextLine();
          continue;
        }
        // ensure their integer is between 1-100
        if (guess < 1 || guess > 100) {
          System.out.println("Error: Your guess must be between 1-100");
          guess = null;
          inputScanner.nextLine();
        }
      }
      // if the user's valid guess is within randomNumber +- 10, exit, they won
      if (guess >= bottomRange && guess <= topRange) {
        System.out.println(
          "Good job! The number was " +
          randomNumber +
          " and you guessed it in " +
          (guesses + 1) +
          " tries."
        );
        inputScanner.close();
        System.exit(0);
      } else if (guesses < 4) {
        System.out.println("Not even close! Try again.");
      }
      guesses++;
    }
    // if the user doesn't win within 5 guesses they lose
    inputScanner.close();
    System.out.println("Sorry, the number was " + randomNumber);
  }
}
