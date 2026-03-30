class Solution {
    public boolean checkStrings(String s1, String s2) {
        return checkWithOffset(s1, s2, 0) && checkWithOffset(s1, s2, 1);
    }

    boolean checkWithOffset(String s1, String s2, int start){
        List<Character> subString1 = new ArrayList<>();
        List<Character> subString2 = new ArrayList<>();
        for(int i = start; i < s1.length(); i += 2){
            subString1.add(s1.charAt(i));
            subString2.add(s2.charAt(i));
        }
        Collections.sort(subString1);
        Collections.sort(subString2);
        return subString1.equals(subString2);
    }
}
// @lc code=end
