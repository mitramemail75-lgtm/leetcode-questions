class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Pair<Integer, Integer>> s = new HashSet<>();
        for(int[] o : obstacles){
            s.add(new Pair<>(o[0], o[1]));
        }
        int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1,0}};
        int idDir = 0;
        int[] cur = {0 ,0};
        int ans = dist(cur);
        for(int c : commands){
            switch(c){
                case -1:
                    idDir += 1;
                    idDir %= dirs.length;
                    break;
                case -2:
                    idDir += 3;
                    idDir %= dirs.length;
                    break;
                default:
                    for(int i = 0; i < c; i++){
                        int[] nxt = new int[]{cur[0] + dirs[idDir][0], cur[1] + dirs[idDir][1]};
                        if(s.contains(new Pair<>(nxt[0], nxt[1]))){
                            break;
                        }
                        cur = nxt;
                        ans = Math.max(dist(cur), ans);
                        // System.out.println(Arrays.toString(cur));
                    }
            }
        }
        return ans;
    }

    int dist(int[] cur){
        return cur[0] * cur[0] + cur[1] * cur[1];
    }
}
// @lc code=end
