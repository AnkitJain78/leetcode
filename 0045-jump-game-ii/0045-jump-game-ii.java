class Solution {
    public int jump(int[] nums) {
        
        if(nums.length == 1)
            return 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int curr = 0;
        for(int i = 0; i < nums.length && i <= curr; i++){
            int cur_reachable = nums[i] + i;
            max = Math.max(cur_reachable, max);
            if(curr == i){
                curr = max;
                count++;
            }
            if(curr >= nums.length - 1)
                return count;
        }
        return 0;
    }
}