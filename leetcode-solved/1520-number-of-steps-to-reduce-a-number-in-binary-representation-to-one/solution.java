import java.math.BigInteger;

class Solution {
  public int numSteps(String s) {
    if (s.isEmpty())
      return 0;
    BigInteger num = new BigInteger(s, 2);
    int countStep= 0;
    // Loop until num equals 1
    while (!num.equals(BigInteger.ONE)) {
      if (num.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
        // num is even
        num = num.divide(BigInteger.TWO);
      } else {
        // num is odd
        num = num.add(BigInteger.ONE);
      }
      countStep += 1;
    }
    return countStep;
  }
}
