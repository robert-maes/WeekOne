package com.smoothstack.day.four;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class Consumer implements Runnable {

  private final BoundedBuffer buf;

  /**
   * Create a new Consumer
   * @param buf reference to a BoundedBuffer
   */
  public Consumer(BoundedBuffer buf) {
    this.buf = buf;
  }

  @Override
  public void run() {
    // loop n times
    for (int i = 1; i <= 10000; i++) {
      // if the buffer is empty, wait until it has something
      while (buf.empty()) {
        try {
          Thread.sleep(1);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      // get the last int out of the buffer
      int n = buf.remove();
      // print it out
      System.out.println(n);
    }
    System.out.println("Consumer finished");
  }
}
