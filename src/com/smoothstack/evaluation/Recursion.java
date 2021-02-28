package com.smoothstack.evaluation;

/**
 * @author Rob Maes
 * Sun Feb 28 2021
 */
public class Recursion {

  /**
   * Determines whether a list of integers can sum to a target value while using either all or no identical adjacent ints
   * @param startPos The position in the array to start checking. Should be 0
   * @param nums The list of integers to check
   * @param targetSum The number the ints should sum to
   * @return True if the ints can sum to the target with respect to the constraints, false if not
   */
  public static boolean groupSumClump(int startPos, int[] nums, int targetSum) {
    // when we reach the end of the list, return whether or not we hit the targetSum
    if (startPos >= nums.length) {
      return targetSum == 0;
    }

    /**
     * If the current int has no adjacent and identical ints then increase the position by one and set the sum
     * equal to the ints value
     *
     * If the current int has adjacent and identical ints then increase the position by one for each of them and set
     * the sum equal to the total sum of all of the equal and identical ints
     */
    int position = startPos;
    int adjSum = 0;
    while (position < nums.length && nums[startPos] == nums[position]) {
      adjSum += nums[position];
      position++;
    }

    // call the function on the remaining ints, subtracting this sum from the targetSum
    if (groupSumClump(position, nums, targetSum - adjSum)) {
      return true;
    }

    // call the function on the remaining ints, skipping over this sum
    if (groupSumClump(position, nums, targetSum)) {
      return true;
    }

    // return false if the target sum cannot be met
    return false;
  }
}
