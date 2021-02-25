package com.smoothstack.day.three;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rob Maes
 * Wed Feb 24 2021
 */
public class FindInFile {

  public static void main(String[] args) {
    // ensure that both arguments are provided by the user
    if (args.length < 2) {
      System.out.println(
        "You must provide a file path as the first argument and a string to search for as the second."
      );
      System.exit(1);
    }
    // initialize the path of the file, the text to search for, and the number of times the text occurs
    final String path = args[0];
    final String searchFor = args[1];
    int totalOccurrences = 0;
    // attempt to open the file
    try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
      // read through the opened file line by line
      String currentLine;
      while ((currentLine = reader.readLine()) != null) {
        // split the line by the search keyword and count the number of splits minus one
        int occurrences = currentLine.split(searchFor, -1).length - 1;
        // add the search keyword occurrences to the total
        totalOccurrences += occurrences;
      }
    } catch (FileNotFoundException e) {
      // if the file does not exist, warn the user
      System.out.println("Could not find file: " + path);
    } catch (IOException e) {
      // catch any other IO errors and warn the user
      System.out.println("An error occurred while reading file " + path);
    }
    // print the total number of times the search keyword occurs in the file
    System.out.println(
      searchFor + " was found " + totalOccurrences + " times in " + path
    );
  }
}
