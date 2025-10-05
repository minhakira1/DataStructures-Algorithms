class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> friendSet = Arrays.stream(friends)
                                       .boxed()
                                       .collect(Collectors.toSet());
        int[] ans = new int[friends.length];
        int j=0;
        for(int i=0;i<order.length;i++){
            if(friendSet.contains(order[i])){
                ans[j] = order[i];
                j++;
            }
        }
        return ans;
    }
}
