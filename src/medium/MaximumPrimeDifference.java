package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumPrimeDifference {
  /**
   * https://leetcode.com/problems/maximum-prime-difference/description/
   * You are given an integer array nums.
   * Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in nums.
   * Example 1:
   * Input: nums = [4,2,9,5,3]
   * Output: 3
   * Explanation: nums[1], nums[3], and nums[4] are prime. So the answer is |4 - 1| = 3.
   * Example 2:
   * Input: nums = [4,8,2,8]
   * Output: 0
   * Explanation: nums[2] is prime. Because there is just one prime number, the answer is |2 - 2| = 0.
   * Constraints:
   * 1 <= nums.length <= 3 * 105
   * 1 <= nums[i] <= 100
   * The input is generated such that the number of prime numbers in the nums is at least one.
   * You are given an integer array nums.
   * Return an integer that is the maximum distance between the indices of two (not necessarily different) prime numbers in nums.
   * Example 1:
   * Input: nums = [4,2,9,5,3]
   * Output: 3
   * Explanation: nums[1], nums[3], and nums[4] are prime. So the answer is |4 - 1| = 3.
   * Example 2:
   * Input: nums = [4,8,2,8]
   * Output: 0
   * Explanation: nums[2] is prime. Because there is just one prime number, the answer is |2 - 2| = 0.
   * Constraints:
   * 1 <= nums.length <= 3 * 105
   * 1 <= nums[i] <= 100
   * The input is generated such that the number of prime numbers in the nums is at least one.
   */

  public static void main(String[] args) {
    int[] nums1 = {4, 2, 9, 5, 3};
    int[] nums2 = {4, 8, 2, 8};

    System.out.println(maximumPrimeDifference(nums1)); // Output: 3
    System.out.println(maximumPrimeDifference(nums2));
  }

  public static int maximumPrimeDifference(int[] nums) {
    List<Integer> primes = findPrimeNumbersByEratosthenes(100);
    List<Integer> primesIndices = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      if (primes.contains(nums[i])) {
        primesIndices.add(i);
      }
    }

    if (primesIndices.size() == 1) {
      return 0;
    }

    return Math.max(0, primesIndices.get(primesIndices.size() - 1) - primesIndices.get(0));
  }


  public static List<Integer> findPrimeNumbersByEratosthenes(int n) {
    boolean[] primes = new boolean[n + 1];
    Arrays.fill(primes, true);
    primes[0] = primes[1] = false;

    for (int i = 2; i * i <= n; i++) {
      if (primes[i]) {
        for (int j = i * i; j <= n; j += i) {
          primes[j] = false;
        }
      }
    }

    List<Integer> primeNumbers = new ArrayList<>();
    for (int i = 2; i <= n; i++) {
      if (primes[i]) {
        primeNumbers.add(i);
      }
    }

    return primeNumbers;
  }
}
