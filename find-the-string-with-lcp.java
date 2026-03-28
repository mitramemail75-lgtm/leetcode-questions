class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] chars = new char[n];
        chars[0] = 'a';
        int cur = 'a';
        for(int i = 1; i < n; i++){
            boolean seen = false;
            for(int j = 0; j < i; j++){
                int diff = lcp[i][j] - ((i < n - 1 && j < n - 1) ? lcp[i + 1][j + 1] : 0);
                if(diff == 1){
                    chars[i] = chars[j];
                    seen = true;
                    break;
                }
            }
            if(!seen){
                cur++;
                chars[i] = (char)cur;
            }
        }
        // System.out.println(String.valueOf(chars));
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int p = (chars[i] == chars[j])? 1 : 0;
                p += (p == 1 && i < n - 1 && j < n - 1) ? lcp[i + 1][j + 1] : 0;
                if(lcp[i][j] != p){
                    // System.out.println(i + ", " + j + ", " + lcp[i][j] + ", " + p);
                    return "";
                }
            }
        }
        if(cur > 'z'){
            return "";
        }
        return String.valueOf(chars);
    }
}
// @lc code=end
