class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return subSetRecForDuplicates(nums, new ArrayList<Integer>());
    }
    static List<List<Integer>> subSetRecForDuplicates(int[] arr, List<Integer> pr){
        
        if(arr.length == 0){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(pr);
            return ans;
        }
        int i = 0;
        while(i+1 < arr.length && arr[i]==arr[i+1])
            i++;
        List<List<Integer>> left = subSetRecForDuplicates(Arrays.copyOfRange(arr,i+1,arr.length),               new ArrayList<>(pr) );
        pr.add(arr[0]);
        List<List<Integer>> right = subSetRecForDuplicates(Arrays.copyOfRange(arr,1,arr.length),pr);
        left.addAll(right);
        return left;
    }
}