class Solution {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            m.putIfAbsent(nums[i], new ArrayList<>());
            m.get(nums[i]).add(i);
        }

        long[] ans = new long[nums.length];
        for(List<Integer> l : m.values()){
            fillDistance(ans, l);
        }
        
        return ans;
    }

    void fillDistance(long[] ans, List<Integer> l){
        long total = 0;
        for(int i = 1; i <= l.size(); i++){
            total += l.get(i - 1) - l.get(0);
        }
        ans[l.get(0)] = total;
        for(int i = 1; i < l.size(); i++){
            total += 1L * (i - (l.size() - i)) * (l.get(i) - l.get(i - 1));
            ans[l.get(i)]  = total;
        }
    }
}
// @lc code=end
