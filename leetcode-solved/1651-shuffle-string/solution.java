class Solution {
    public String restoreString(String s, int[] indices) {
        Map<Integer, Character> mapAns = new HashMap<Integer, Character>();
        for(int i=0;i<indices.length;i++) {
            mapAns.put(indices[i], s.charAt(i));
        }
        StringBuilder ans = new StringBuilder(indices.length);
        for(int i=0;i<indices.length;i++){
            ans.append(mapAns.get(i));
        }
 return ans.toString();   
}
}
