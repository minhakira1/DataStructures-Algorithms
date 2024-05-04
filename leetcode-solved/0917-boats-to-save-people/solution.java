class Solution {
  public static int numRescueBoats(int[] people, int limit) {
    Arrays.sort(people);
    int pointerMin = 0, pointerMax = people.length - 1;
    int ans = 0;
    while (pointerMin <= pointerMax) {
      if (people[pointerMin] + people[pointerMax] <= limit) {
        ans++;
        pointerMin++;
        pointerMax--;
      } else {
        pointerMax--;
        ans++;
      }
    }
    return ans;
  }
}
