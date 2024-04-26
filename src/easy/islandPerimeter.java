package easy;

public class islandPerimeter {

  public static void main(String[] args) {
    int[][] arr = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
//    int[][] arr = {{1, 0}};
    System.out.println(islandPerimeter(arr));
  }

  public static int islandPerimeter(int[][] grid) {
    int sum = 0;
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[row].length; col++) {
        if (grid[row][col] == 1) {
          sum += 4;
        }
        if (col > 0 && grid[row][col] == 1 && grid[row][col] == grid[row][col - 1]) {
          sum -= 2;
        }
        if (row > 0 && grid[row][col] == 1 && grid[row - 1][col] == grid[row][col]) {
          sum -= 2;
        }
      }
    }

    return sum;
  }
}
