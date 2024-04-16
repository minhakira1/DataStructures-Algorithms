import java.util.*;

public class KthSmallestAmount {
  public int kthSmallestAmount(int[] coins, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int count = 0;
    for (int i = 0; i < coins.length; i++) {
      pq.offer(coins[i]);
      ++count;
      if (count == k) {
        return pq.poll();
      }
      if (i + 1 <= coins.length -1) {
        long value = coins[i];
        while(value <= coins[i+1]) {
          String str = new String("minh");

        }
      }
    }


    return pq.poll();
  }

  public static void main(String[] args) {
    KthSmallestAmount solution = new KthSmallestAmount();

    // Example 1
    int[] coins1 = {3, 6, 9};
    int k1 = 3;
    System.out.println("Example 1 Output: " + solution.kthSmallestAmount(coins1, k1)); // Output: 9

    // Example 2
    int[] coins2 = {5, 2};
    int k2 = 7;
    System.out.println("Example 2 Output: " + solution.kthSmallestAmount(coins2, k2)); // Output: 12
  }
}
