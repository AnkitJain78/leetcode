/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
class Solution {
   static int binary_search(MountainArray mountain, int target, int l, int r, boolean revert) {
        while (l <= r) {
            int mid = (l + r)/2;
            int cur = mountain.get(mid);
            if (cur == target)
                return mid;
            if(revert){
               if(cur < target) {
                   r = mid - 1;
               }else{
                   l = mid + 1;
               }
            }else{
                if (cur < target)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }
public static int findInMountainArray(int target, MountainArray mountainArr) {
        int l = 0, r = mountainArr.length() - 1;
        while (l < r) {
            int mid = (l + r)/2;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1))
                l = mid + 1;
            else
                r = mid;
        }
        int peak = l;
        int index = binary_search(mountainArr, target, 0, peak, false);
        if (index != -1)
            return index;
        return binary_search(mountainArr, target, peak + 1, mountainArr.length()-1, true);
    }
}
