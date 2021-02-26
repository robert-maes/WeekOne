package com.smoothstack.day.four;

/**
 * @author Rob Maes
 * Thu Feb 25 2021
 */
public class RunProducerConsumer {

  public static void main(String[] args) {
    // create a BoundedBuffer of a fixed size
    BoundedBuffer buf = new BoundedBuffer(1000);
    // create the producer and consumer
    Runnable producer = new Producer(buf);
    Runnable consumer = new Consumer(buf);
    // create a thread for the producer and a thread for the consumer
    Thread producerThread = new Thread(producer);
    Thread consumerThread = new Thread(consumer);
    // start the threads
    producerThread.start();
    consumerThread.start();
  }
}
