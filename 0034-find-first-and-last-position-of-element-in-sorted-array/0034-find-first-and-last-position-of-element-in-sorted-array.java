class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int start = binarySearch(nums, target, true);
        if(start == -1){
            return new int[]{-1,-1};
        }
        int end = binarySearch(nums, target, false);
        return new int[]{start,end};
}
    static int binarySearch(int[] nums, int target, boolean findStartIndex)
    {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(nums[mid] > target)
                end = mid - 1;
            else if(nums[mid] < target)
                start = mid + 1;
            else{
                ans = mid;
                if(findStartIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
    }