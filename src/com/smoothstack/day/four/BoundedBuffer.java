package com.smoothstack.day.four;

import java.util.Arrays;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class BoundedBuffer {

  private int[] buffer;
  private final int size;
  private int numItems = 0;

  /**
   * Create a new BoundedBuffer of a fixed size
   * @param size The max number of integers the BoundedBuffer can store
   */
  public BoundedBuffer(int size) {
    this.buffer = new int[size];
    this.size = size;
  }

  /**
   * Determines whether another integer can be added to the BoundedBuffer
   * @return True if another element can be added, false if not
   */
  public synchronized boolean hasRoom() {
    return numItems < size;
  }

  /**
   * Determines whether the BoundedBuffer is currently empty
   * @return True if the buffer is empty, false if not
   */
  public synchronized boolean empty() {
    return !(numItems > 0);
  }

  /**
   * Adds an integer to the front of the buffer
   * @param n The integer to add
   */
  public synchronized void add(int n) {
    // shift the entire array right once
    shiftRight();
    // set n as the first element of the array
    buffer[0] = n;
    // increment the current number of elements
    numItems++;
  }

  /**
   * Removes the last integer from the back of the buffer
   * @return The last integer in the buffer
   */
  public synchronized int remove() {
    // set n to the index for the last element in the array
    int n = buffer[numItems - 1];
    // decrement the number of elements
    numItems--;
    return n;
  }

  /**
   * Shifts each element in the buffer array over to right once
   */
  private void shiftRight() {
    // create a new temp array
    int[] swap = new int[size];
    // loop through the current array
    for (int i = 0; i < size; i++) {
      // set the int at currentArray[i] to tempArray[i+1], except for the very last element
      if (i != size - 1) {
        swap[i + 1] = buffer[i];
      }
    }
    // set current array to temp array
    buffer = swap;
  }

  @Override
  public String toString() {
    return "BoundedBuffer{" + "buffer=" + Arrays.toString(buffer) + '}';
  }
}
