import java.math.BigInteger;
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
  StringBuilder numberStr = new StringBuilder(10000);
        for (int i : num) {
            numberStr.append(i);
        }
        numberStr = new StringBuilder(String.valueOf(new BigInteger(numberStr.toString()).add(
                BigInteger.valueOf(k))));
        return Arrays.stream(numberStr.toString().split("")).map(Integer::parseInt).collect(Collectors.toList());
   
   
    }
}
