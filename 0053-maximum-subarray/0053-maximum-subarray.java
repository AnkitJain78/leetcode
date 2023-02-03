class Solution {
    public int maxSubArray(int[] nums) {
        int cur_sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            int cur_value = nums[i];
            cur_sum = cur_value + cur_sum;
            if(cur_sum>max)
                max = cur_sum;
            if(cur_sum<0)
                cur_sum = 0;
        }
        return max;
    }
}