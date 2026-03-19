class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] freq = new int[n + 1][m + 1][2];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int b = 0; b < 2; b++) {
                    freq[i][j][b] = freq[i - 1][j][b] + freq[i][j - 1][b] - freq[i - 1][j - 1][b];
                }
                if (grid[i - 1][j - 1] == 'X') {
                    freq[i][j][0]++;
                } else if (grid[i - 1][j - 1] == 'Y') {
                    freq[i][j][1]++;
                }
                if (freq[i][j][0] == freq[i][j][1] && freq[i][j][0] != 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
