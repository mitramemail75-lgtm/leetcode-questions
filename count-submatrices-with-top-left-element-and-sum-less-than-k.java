class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] += ((i > 0) ? grid[i - 1][j] : 0) + ((j > 0) ? grid[i][j - 1] : 0) - ((i > 0 && j > 0) ? grid[i - 1][j - 1] : 0);
                if(grid[i][j] <= k){
                    ans++;
                }
            }
        }
        return ans;
    }
}
// @lc code=end
