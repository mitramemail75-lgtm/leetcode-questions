class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
    	for(int i = 0; i < 4; i++){
    		if(check(mat, target)){
    			return true;
    		}
    		mat = rotate(mat);
    	}
    	return false;
    }

    int[][] rotate(int[][] mat){
    	int n = mat.length;
    	int[][] ret = new int[n][n];
    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < n; j++){
    			ret[i][j] = mat[j][n - i - 1];
    		}
    	}
    	return ret;
    }

    boolean check(int[][] mat1, int[][] mat2){
    	int n = mat1.length;
    	for(int i = 0; i < n; i++){
    		for(int j = 0; j < n; j++){
    			if(mat1[i][j] != mat2[i][j]){
    				return false;
    			}
    		}
    	}
    	return true;
    }
}
// @lc code=end
