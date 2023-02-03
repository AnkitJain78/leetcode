class Solution {
    public int findMin(int[] nums) {
        int max = peak(nums);
        if(max == -1)
            return nums[0];
        else
            return nums[max + 1];
        
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
            else if(nums[mid] > nums[start] || (nums[mid] == nums[start] && nums[mid] > nums[end] ))
                start = mid + 1;
            else if(nums[mid] < nums[start] || (nums[mid] == nums[start] && nums[mid] < nums[end] ))
                end = mid - 1;
            else
            {
                if(start < nums.length -1 && nums[start] > nums[start + 1])
                    return start;
                else if(end > 0 && nums[end] < nums[end - 1])
                    return end - 1;
                else
                {
                    start++;
                    end--;
                }
            }
        }
        return -1;
    }    
    
}