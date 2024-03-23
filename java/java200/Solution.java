package java200;

class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0, j = 0;
        int res = 0;
        boolean[][] v = new boolean[m][n];
        for (i = 0; i < m; i++)
            for (j = 0; j < n; j++) {
                if (!v[i][j] && grid[i][j] == '1') {
                    res++;
                    dfs(grid, v, i, j);
                }
            }
        return res;
    }

    public void dfs(char[][] grid, boolean[][] v, int x, int y) {
        int m = grid.length;
        int n = grid[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n)
            return;
        if (v[x][y] || grid[x][y] == '0')
            return;
        v[x][y] = true;
        dfs(grid, v, x - 1, y);
        dfs(grid, v, x, y - 1);
        dfs(grid, v, x + 1, y);
        dfs(grid, v, x, y + 1);
    }
}