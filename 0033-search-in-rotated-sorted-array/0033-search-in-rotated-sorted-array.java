class Solution {
    public int search(int[] nums, int target) {
        int max = peak(nums);
        if(max == -1)
            return binarySearch(nums,target,0,nums.length - 1);
        if(target == nums[max])
            return max;
        else if(target >= nums[0])
        return binarySearch(nums,target,0,max - 1);
        else
        return binarySearch(nums, target, max + 1, nums.length - 1);
    }
    static int peak(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1])
                return mid;
            else if(mid > 0 && nums[mid - 1] > nums[mid])
                return mid - 1;
            else if(nums[mid] > nums[start])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
    static int binarySearch(int[] nums, int target,int start,int end)
    {
        while(start <= end)
        {
            int mid = start + (end - start)/2;
            if(nums[mid] < target)
                start = mid + 1;
            else if(nums[mid] == target)
                return mid;
            else
                end = mid - 1;
        }
        return -1;
    }
}