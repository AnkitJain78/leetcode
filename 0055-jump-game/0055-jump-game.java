class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1)
            return true;
        if(nums[0]==0)
            return false;
        int maxReachable = 0;
        int curReachable = 0;
        for(int i = 0; i < nums.length && i <= maxReachable; i++){
            curReachable = i + nums[i];
            maxReachable = Math.max(curReachable,maxReachable);
            if(maxReachable>=nums.length-1)
                return true;
        }
        return false;
    }
    
}