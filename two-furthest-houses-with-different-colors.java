class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = n - 1; j >= 0; j--){
                if(colors[i] != colors[j]){
                    ret = Math.max(ret, j - i);
                    break;
                }
            }
        }
        return ret;
    }
}
// @lc code=end
