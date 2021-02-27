package com.smoothstack.evaluation;

import java.util.ArrayList;

//todo understand this
public class Recursion {

  //start = 0, [2,4,8], 10 -> true
  public static boolean groupSumClump(int start, int[] nums, int target) {
    // if we went through the entire array check whether we met the target
    if (start >= nums.length) return target == 0;
    int i = start;
    int sum = 0;
    while (i < nums.length && nums[start] == nums[i]) {
      sum += nums[i];
      i++;
    }
    // continue trying to meet target, including this number
    if (groupSumClump(i, nums, target - sum)) {
      return true;
    }
    // continue trying to meet target, skipping this number
    if (groupSumClump(i, nums, target)) {
      return true;
    }
    return false;
  }
}
