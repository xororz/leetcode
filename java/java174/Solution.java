package java174;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] res = new int[m][n];
        res[m - 1][n - 1] = Math.max(0, -dungeon[m - 1][n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            res[m - 1][i] = Math.max(0, res[m - 1][i + 1] - dungeon[m - 1][i]);
        }
        for (int i = m - 2; i >= 0; i--) {
            res[i][n - 1] = Math.max(0, res[i + 1][n - 1] - dungeon[i][n - 1]);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                res[i][j] = Math.max(0, Math.min(res[i + 1][j], res[i][j + 1]) - dungeon[i][j]);
            }
        }
        return res[0][0] + 1;
    }

    public static void main(String[] args) {
        int[][] dungeon = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
        System.out.println(new Solution().calculateMinimumHP(dungeon));
    }
}