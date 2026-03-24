class Solution {
    int MOD = 12345;
    
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] accumProducts = new int[n][][]; 
        int[] productOfProducts = new int[n];
        for(int i = 0; i < n; i++){
            accumProducts[i] = getAccumulatedProduct(grid[i]);
            productOfProducts[i] = accumProducts[i][0][m - 1];
        }
        int[][] accumProductsOfProducts = getAccumulatedProduct(productOfProducts);
        int[][] ans = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                long productOfLinesBefore = 1L;
                if(i > 0){
                    productOfLinesBefore = accumProductsOfProducts[0][i - 1];
                }
                long productOfLinesAfter = 1L;
                if(i < n - 1){
                    productOfLinesAfter = accumProductsOfProducts[1][i + 1];
                }
                long productOfNumsBefore = 1L;
                if(j > 0){
                    productOfNumsBefore = accumProducts[i][0][j - 1];
                }
                long productOfNumsAfter = 1L;
                if(j < m - 1){
                    productOfNumsAfter = accumProducts[i][1][j + 1];
                }
                long cur = 1L; 
                cur *= productOfLinesBefore;
                cur %= MOD;
                cur *= productOfLinesAfter;
                cur %= MOD;
                cur *= productOfNumsBefore;
                cur %= MOD;
                cur *= productOfNumsAfter;
                cur %= MOD;
                ans[i][j] = (int)cur;
            }
        }
        return ans;
    }

    int[][] getAccumulatedProduct(int[] a){
        int n = a.length;
        int[][] ret = new int[2][n];
        for(int i = 0; i < n; i++){
            long prev = 1L;
            if(i > 0){
                prev = ret[0][i - 1];
            }
            ret[0][i] = (int)((prev * a[i]) % MOD);
        }
        for(int i = n - 1; i >= 0; i--){
            long prev = 1L;
            if(i < n - 1){
                prev = ret[1][i + 1];
            }
            ret[1][i] = (int)((prev * a[i]) % MOD);
        }
        return ret;
    }
}
// @lc code=end
