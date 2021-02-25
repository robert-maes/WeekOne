package com.smoothstack.day.three;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

/**
 * @author Rob Maes
 * Wed Feb 24 2021
 */
public class AppendText {

  public static void main(String[] args) {
    // initialize target path and text to append
    String path = "";
    String toAppend = "";
    // create a new input scanner and prompt user for the path and text to append
    Scanner input = new Scanner(System.in);
    System.out.println(
      "Please enter the path of the file you wish to modify: "
    );
    path = input.nextLine();
    System.out.println(
      "Please enter the text you wish to append to the file: "
    );
    toAppend = input.nextLine();
    input.close();
    // attempt to append text to the file
    try {
      Files.write(
        Paths.get(path),
        toAppend.getBytes(),
        StandardOpenOption.APPEND
      );
      // provide confirmation to the user upon success
      System.out.println("Added " + toAppend + " to " + path + " successfully");
    } catch (NoSuchFileException e) {
      // Tell the user if the file does not exist
      System.out.println("File: " + path + " does not exist.");
    } catch (IOException e) {
      // Catch all other IO errors and present the error to the user
      System.out.println("An error occurred while writing to the file.");
    }
  }
}
