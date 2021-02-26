package com.smoothstack.day.four;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class Deadlock {

  public static void main(String[] args) {
    Double d = 1.0;
    Character c = 'A';

    System.out.println("Start deadlock");

    Runnable thread1 = new Runnable() {
      @Override
      public void run() {
        try {
          // lock thread1 to d
          synchronized (d) {
            System.out.println("Thread 1 locked to d");
            Thread.sleep(10);
            System.out.println("Thread 1 waiting to lock to c");
            // try to lock thread1 to c -- doesn't work, thread2 is locked to c
            synchronized (c) {
              System.out.println("Thread 1 is locked to d and c");
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Thread 1 finished");
      }
    };

    Runnable thread2 = new Runnable() {
      @Override
      public void run() {
        try {
          // lock thread2 to c
          synchronized (c) {
            System.out.println("Thread 2 locked to c");
            Thread.sleep(10);
            System.out.println("Thread 2 waiting to lock to d");
            // try to lock thread2 to d -- doesn't work, thread1 is locked to d
            synchronized (d) {
              System.out.println("Thread 2 locked to c and d");
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("Thread 2 finished");
      }
    };

    new Thread(thread1).start();
    new Thread(thread2).start();

    System.out.println("End deadlock");
  }
}
