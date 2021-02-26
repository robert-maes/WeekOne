package com.smoothstack.day.four;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class ThreadSafeSingleton {

  // initialize single instance to null
  private static volatile ThreadSafeSingleton instance = null;

  // private constructor to prevent creating objects
  private ThreadSafeSingleton() {}

  public static ThreadSafeSingleton getInstance() {
    // first check if the instance is null before locking
    // this is more performant as it eliminates unnecessary locks
    if (instance == null) {
      synchronized (ThreadSafeSingleton.class) {
        // check again that it is null now that the thread is locked
        if (instance == null) {
          // create the new sole object of this class
          instance = new ThreadSafeSingleton();
        }
      }
    }
    // return a reference to the sole object of this class
    return instance;
  }
}
