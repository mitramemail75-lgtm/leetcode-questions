class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        long MAX = (long)1e12;
        Collections.sort(robot);
        List<Integer> factories = Arrays.stream(factory)
                .flatMap((int[] ff) -> 
                    IntStream.range(0, ff[1])
                    .map(i -> ff[0]).boxed()
                )
                .sorted()
                .collect(Collectors.toList());
        long[][] dp = new long[robot.size() + 1][factories.size() + 1];
        for(int i = 0; i < dp.length; i++){
            // Arrays.fill(dp[i], MAX);
            dp[i][0] = MAX;
        }
        dp[0][0] = 0;
        for(int i = 1; i <= robot.size(); i++){
            for(int j = 1; j <= factories.size(); j++){
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + Math.abs(robot.get(i - 1) - factories.get(j - 1)));
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return dp[robot.size()][factories.size()];
    }
}
// @lc code=end
