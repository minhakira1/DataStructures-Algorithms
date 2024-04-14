class Solution {
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

       return Math.max(0, primesIndices.get(primesIndices.size() -1) - primesIndices.get(0));
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
