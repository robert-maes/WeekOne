package com.smoothstack.day.four;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class Producer implements Runnable {

  private final BoundedBuffer buf;

  /**
   * Create a new Producer
   * @param buf reference to a BoundedBuffer
   */
  public Producer(BoundedBuffer buf) {
    this.buf = buf;
  }

  @Override
  public void run() {
    // loop n times
    for (int i = 1; i <= 10000; i++) {
      // if the buffer is full, wait until it is empty
      while (!buf.hasRoom()) {
        try {
          Thread.sleep(1);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      // add an int to the buffer
      buf.add(i);
    }
    System.out.println("Producer finished");
  }
}
