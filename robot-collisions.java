class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<Integer> leftToRight = new ArrayList<>();
        List<Integer> rightToLeft = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < positions.length; i++){
            if(directions.charAt(i) == 'L'){
                rightToLeft.add(i);
            }
            else{
                leftToRight.add(i);
            }
        }
        Collections.sort(leftToRight, Comparator.comparing(i -> positions[i]));
        Collections.sort(rightToLeft, Comparator.comparing(i -> positions[i]));
        Stack<Integer> stack = new Stack<>();
        // System.out.println(leftToRight);
        // System.out.println(rightToLeft);
        int i = leftToRight.size() - 1;
        int j = rightToLeft.size() - 1;

        while(i >= 0 && (j >= 0 || !stack.isEmpty())){
            while(j >= 0 && positions[leftToRight.get(i)] < positions[rightToLeft.get(j)]){
                stack.push(rightToLeft.get(j));
                j--;
            }
            
            boolean eliminated = false;
            while(!stack.isEmpty()){
                if(healths[stack.peek()] < healths[leftToRight.get(i)]){
                    stack.pop();
                    healths[leftToRight.get(i)]--;
                }
                else if(healths[stack.peek()] == healths[leftToRight.get(i)]){
                    eliminated = true;
                    stack.pop();
                    break;
                }
                else{
                    healths[stack.peek()]--;
                    eliminated = true;
                    break;
                }
            }
            // System.out.println(Arrays.toString(healths));
            if(!eliminated){
                ans.add(leftToRight.get(i));
            }
            i--;
        }
        while(i >= 0){
            ans.add(leftToRight.get(i));
            i--;
        }
        while(j >= 0){
            ans.add(rightToLeft.get(j));
            j--;
        }
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans.stream().sorted().map(k -> healths[k]).collect(Collectors.toList());
    }
}
// @lc code=end
