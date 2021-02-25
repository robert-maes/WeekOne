package com.smoothstack.day.three;

import java.io.File;

/**
 * @author Rob Maes
 * Wed Feb 24 2021
 */
public class ListDirectory {

  public static void main(String[] args) {
    // If a directory argument is not provided, show an error, otherwise print out it's children
    if (args.length == 0) {
      System.out.println("Please provide a directory as the first argument.");
    } else {
      printFiles(args[0], 0);
    }
  }

  /**
   * Prints all child folders and files of the given directory, recursively
   * @param path The absolute or relative path of a directory
   * @param level Keeps track of depth into nested folders. Should be 0 for the first call
   */
  public static void printFiles(String path, int level) {
    // Attempt to locate the directory and its children
    File parent = new File(path);
    File[] children = parent.listFiles();
    if (children != null) {
      // loop through each child
      for (File child : children) {
        // print out the child's name with the correct indentation
        printWithIndent(child.getName(), level * 2);
        // if the child is a directory, call this function recursively, incrementing the level of depth
        if (child.isDirectory()) {
          printFiles(child.getPath(), level + 1);
        }
      }
    } else {
      // If the directory cannot be found or if it is empty, show an error
      System.out.println(
        "Could not find the directory: " + path + " or it may be empty."
      );
    }
  }

  /**
   * Prints out a string with n spaces before it
   * @param message The string to print
   * @param indentation The number of spaces to put before the string
   */
  public static void printWithIndent(String message, int indentation) {
    // create a StringBuilder
    StringBuilder messageBuilder = new StringBuilder(message);
    // add n spaces before the string
    for (int i = 0; i < indentation; i++) {
      messageBuilder.insert(0, " ");
    }
    // print out the string
    message = messageBuilder.toString();
    System.out.println(message);
  }
}
