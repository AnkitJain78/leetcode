class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subSetRec(nums, new ArrayList<Integer>());
    }
    static List<List<Integer>> subSetRec(int[] arr, List<Integer> pr){
        if(arr.length == 0){
            List<List<Integer>> ans = new ArrayList<>();
            ans.add(pr);
            return ans;
        }
        List<List<Integer>> left = subSetRec(Arrays.copyOfRange(arr,1,arr.length), new ArrayList<>(pr) );
        pr.add(arr[0]);
        List<List<Integer>> right = subSetRec(Arrays.copyOfRange(arr,1,arr.length),pr);
        left.addAll(right);
        return left;
    }
}