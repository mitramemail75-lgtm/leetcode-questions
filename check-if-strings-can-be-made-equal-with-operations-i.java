class Solution {
    public boolean canBeEqual(String s1, String s2) {
        int[][] idGroups = {{0, 2}, {1, 3}};
        return Arrays.stream(idGroups).allMatch(g -> 
            (s1.charAt(g[0]) == s2.charAt(g[0]) && s1.charAt(g[1]) == s2.charAt(g[1]))
            || (s1.charAt(g[0]) == s2.charAt(g[1]) && s1.charAt(g[1]) == s2.charAt(g[0])));
    }
}
// @lc code=end
