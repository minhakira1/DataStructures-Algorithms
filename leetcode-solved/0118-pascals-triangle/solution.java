class Solution {
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> res = new ArrayList<>();
    int row = 1;
    while (row <= numRows) {
      if (row == 1) {
        res.add(new ArrayList<>(List.of(1)));
        row++;
        continue;
      }
      List<Integer> rowList = new ArrayList<>();
      List<Integer> aboveList = res.get(row - 1 - 1);
      for (int i = 0; i < row; i++) {
        //số 2 cạnh luôn bằng 1
        if (i == 0 || i == row-1) { rowList.add(1);}
        // số trong bằng công thức 2 số trên
        else {
          rowList.add(aboveList.get(i - 1) + aboveList.get(i));}
      }
      res.add(rowList);
      row++;
    }
    return res;
  }
}
