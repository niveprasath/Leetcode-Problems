class Solution {
    public int islandPerimeter(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] vis = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    // Start DFS from the first land cell found and return immediately
                    return dfs(i, j, r, c, grid, vis);
                }
            }
        }
        return 0;
    }

    private int dfs(int i, int j, int r, int c, int[][] grid, int[][] vis) {
        // Out of bound or water cell indicates an exposed perimeter edge
        if (i < 0 || i >= r || j < 0 || j >= c) return 1;
        if (grid[i][j] == 0) return 1;
        if (vis[i][j] == 1) return 0;

        vis[i][j] = 1; // Mark as visited

        int perimeter = 0;
        perimeter += dfs(i - 1, j, r, c, grid, vis); // up
        perimeter += dfs(i + 1, j, r, c, grid, vis); // down
        perimeter += dfs(i, j - 1, r, c, grid, vis); // left
        perimeter += dfs(i, j + 1, r, c, grid, vis); // right

        return perimeter;
    }
}