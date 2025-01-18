class Solution {
  public int minCost(int[][] grid) {
    if (grid == null || grid.length == 0)
      return 0;
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    boolean[][] seen = new boolean[grid.length][grid[0].length];
    Deque<int[]> queue = new ArrayDeque<>();
    dfs(grid, queue, seen, dirs, 0, 0);
    int numSteps = 0; // Number of BFS steps we made so far. All nodes currently in the queue are
                      // reachable with exactly this cost.

    while (queue.size() > 0) {
      // Remove all positions that are currently in the queue (nodes reachable with
      // cost numSteps) and add all positions reachable with the next BFS step (nodes
      // reachable with cost numSteps + 1).
      for (int i = queue.size(); i > 0; --i) {
        int[] currPos = queue.removeFirst();
        if (currPos[0] == grid.length - 1 && currPos[1] == grid[0].length - 1) {
          return numSteps;
        }
        // Make a step into unseen neighbouring positions.
        for (int[] currDir : dirs) {
          int newRow = currPos[0] + currDir[0], newCol = currPos[1] + currDir[1];
          if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length && !seen[newRow][newCol]) {
            dfs(grid, queue, seen, dirs, newRow, newCol);
          }
        }
      }
      numSteps++;
    }
    return -1;
  }

  // DFS that "follows the arrows". It marks reached positions as seen and adds
  // them to the end of the queue.
  private void dfs(int[][] grid, Deque<int[]> queue, boolean[][] seen, int[][] dirs, int row, int col) {
    assert (!seen[row][col]);
    queue.addLast(new int[] { row, col });
    seen[row][col] = true;

    int newRow = row + dirs[grid[row][col] - 1][0], newCol = col + dirs[grid[row][col] - 1][1];
    if (0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length && !seen[newRow][newCol]) {
      dfs(grid, queue, seen, dirs, newRow, newCol);
    }
  }
}
