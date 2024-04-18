class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    sum += 4;
                    if (col > 0 && grid[row][col] == grid[row][col - 1]) {
                        sum -= 2;
                    }
                    if (row > 0 && grid[row - 1][col] == grid[row][col]) {
                        sum -= 2;
                    }
                }

            }
        }

        return sum;
    }
}
