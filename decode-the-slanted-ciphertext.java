class Solution {
    int cols;
    public String decodeCiphertext(String encodedText, int rows) {
        int n = encodedText.length();
        cols = n / rows;
        StringBuilder sb = new StringBuilder();
        for(int d = 0; d < cols; d++){
            String t = "";
            for(int r = 0; r < rows; r++){
                int idx = getIdx(r, r + d);
                if(idx >= n){
                    break;
                }
                t += encodedText.charAt(idx);
            }
            sb.append(t);
        }
        return sb.toString().stripTrailing();
    }

    int getIdx(int r, int c){
        return r * cols + c;
    }
}
// @lc code=end
