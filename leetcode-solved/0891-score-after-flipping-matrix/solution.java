class Solution {
  public int matrixScore(int[][] grid) {
    for (int i = 0; i < grid.length; i++) {
      StringBuilder binaryOrigin = new StringBuilder(grid[i].length);
      StringBuilder binaryFlipped = new StringBuilder(grid[i].length);
      for (int j = 0; j < grid[i].length; j++) {
        binaryOrigin.append(grid[i][j]);
        binaryFlipped.append(grid[i][j] == 1 ? 0 : 1);
      }
      int decimalOrigin = Integer.parseInt(binaryOrigin.toString(), 2);
      int decimalFlipped = Integer.parseInt(binaryFlipped.toString(), 2);
      if (decimalFlipped > decimalOrigin) {
        for (int j = 0; j < grid[i].length; j++) {
          grid[i][j] = grid[i][j] == 1 ? 0 : 1;
        }
      }
    }
    for (int j = 0; j < grid[0].length; j++) {
      int countFlipOto1 = 0;
      for (int i = 0; i < grid.length; i++) {
        if (grid[i][j] == 0) {
          countFlipOto1++;
        }
      }
      if (countFlipOto1 > grid.length / 2) {
        for (int i = 0; i < grid.length; i++) {
          grid[i][j] = grid[i][j] == 1 ? 0 : 1;
        }
      }
    }
    int sum = 0;
    for (int[] row : grid) {
      StringBuilder binaryOrigin = new StringBuilder(row.length);
      for (int col : row) {
        binaryOrigin.append(col);
      }
      sum += Integer.parseInt(binaryOrigin.toString(), 2);
    }
    return sum;
  }
}
