class Solution {
    public int findKthLargest(int[] nums, int k) {
        int kthLargestIndex = nums.length - k;
        return quickSelect(nums, 0, nums.length - 1, kthLargestIndex);
    }

    public int quickSelect(int[] nums, int start, int end, int kthLargestIndex) {
        if(start < end) { 
            int partition = partition(nums, start, end);
            if(partition == kthLargestIndex) {
                return nums[partition];
            } else if (partition > kthLargestIndex) {
                return quickSelect(nums, start, partition - 1, kthLargestIndex);
            } else {
                return quickSelect(nums, partition + 1, end, kthLargestIndex);
            }
        } 
        else {
            return nums[start];
        }
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int wall = start - 1;
        for(int scan = start; scan < end; scan++) {
            if(nums[scan] <= pivot){
                wall++;
                swap(nums, wall, scan);
            }
        }
        swap(nums, end, wall + 1);
        return wall + 1;
    }

    private void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
