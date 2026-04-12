class Solution {
    public int minimumDistance(String word) {
    	int n = word.length();
    	int MAX = 300 * 100 + 5;
    	int[][] dp = new int[n + 1][n + 1];    

    	for(int i = 0; i <= n; i++){
    		if(i + 1 <= n){
    			dp[i][i + 1] = dp[0][i];
    			for(int j = 1; j < i; j++){
    				dp[i][i + 1] = Math.min(dp[i][i + 1], dp[j][i] + dist(word.charAt(j - 1), word.charAt(i)));
    			}
    		}
    		for(int j = i + 2; j <= n; j++){
    			dp[i][j] = dp[i][j - 1] + dist(word.charAt(j - 2), word.charAt(j - 1));
    		}
    	}
    	// System.out.println(Arrays.deepToString(dp));
    	int minDis = MAX;
    	for (int i = 0; i < n; i++) {
    		minDis = Math.min(minDis, dp[i][n]);
    	}
    	return minDis;
    }

    int dist(char a, char b){
    	int[] fi = getCoordinate(a);
    	int[] se = getCoordinate(b);
    	return Math.abs(fi[0] - se[0]) + Math.abs(fi[1] - se[1]);
    }

    int[] getCoordinate(char a){
    	int offset = a - 'A';
    	return new int[]{offset / 6, offset % 6};
    }
}
// @lc code=end
