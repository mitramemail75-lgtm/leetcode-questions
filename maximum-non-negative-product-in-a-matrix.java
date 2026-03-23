class Solution {
    public int maxProductPath(int[][] grid) {
    	int n = grid.length;
    	int m = grid[0].length;
    	long[][] minNeg = new long[n][m];
    	long[][] maxPos = new long[n][m];
    	boolean hasZero = false;
    	if(grid[0][0] == 0){
    		return 0;
    	}
    	else{
    		minNeg[0][0] = grid[0][0];	
    		maxPos[0][0] = grid[0][0];	
    	}
    	
    	for(int i = 1; i < n; i++){
    		if(grid[i][0] == 0){
    			hasZero = true;
    		}
    		else if(grid[i][0] < 0){
    			maxPos[i][0] = minNeg[i - 1][0] * grid[i][0];
    			minNeg[i][0] = maxPos[i - 1][0] * grid[i][0];
    		}
    		else{
    			minNeg[i][0] = minNeg[i - 1][0] * grid[i][0];	
    			maxPos[i][0] = maxPos[i - 1][0] * grid[i][0];	
    		}
    	}
    	for(int i = 1; i < m; i++){
    		if(grid[0][i] == 0){
    			hasZero = true;
    		}
    		else if(grid[0][i] < 0){
    			maxPos[0][i] = minNeg[0][i - 1] * grid[0][i];
    			minNeg[0][i] = maxPos[0][i - 1] * grid[0][i];
    		}
    		else{
    			minNeg[0][i] = minNeg[0][i - 1] * grid[0][i];	
    			maxPos[0][i] = maxPos[0][i - 1] * grid[0][i];
    		}
    	}
    	
        for(int i = 1; i < n; i++){
        	for(int j = 1; j < m; j++){
        		if(grid[i][j] == 0){
        			hasZero = true;
        		}
        		else{
	        		long min = Math.min(minNeg[i - 1][j], minNeg[i][j - 1]);
	        		long max = Math.max(maxPos[i - 1][j], maxPos[i][j - 1]);
	        		if(grid[i][j] < 0){
	        			minNeg[i][j] = 	max * grid[i][j];
	        			maxPos[i][j] = 	min * grid[i][j];
	        		}
	        		else{
	        			minNeg[i][j] = 	min * grid[i][j];
	        			maxPos[i][j] = 	max * grid[i][j];
	        		}	
        		}
        	}
        }
        System.out.println(Arrays.deepToString(minNeg));
        System.out.println(Arrays.deepToString(maxPos));
        if(maxPos[n - 1][m - 1] < 0){
        	return hasZero ? 0 : -1;
        }
        else{
        	return (int)(maxPos[n - 1][m - 1] % 1000000007);
        }
    }
}
// @lc code=end
