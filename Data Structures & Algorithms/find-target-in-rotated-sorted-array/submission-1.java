class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length < 1){
            return -1;
        }
        int l = 0;
        int h = nums.length - 1;
        while(l <= h){
            int mid = (l+h)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[l] <= nums[mid]){
                //if left side is sorted
                if(nums[l] <= target && target <= nums[mid]) {
                    h = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                //check right side
                //nums[mid] < target <= nums[h]
                if(nums[mid] <= target && target <= nums[h]){
                    l = mid +1;
                } else {
                    h = mid - 1;
                }
            }

        }
        return -1;
    }
}
