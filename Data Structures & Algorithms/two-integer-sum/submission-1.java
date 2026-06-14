class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[] {-1,-1};
        HashMap<Integer, Integer> tracker = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++){
            int currentValue = nums[i];
            int difference = target - currentValue;
            if(tracker.containsKey(difference)) {
                result[0] = tracker.get(difference);
                result[1] = i;
            } else {
                tracker.put(currentValue, i);
            }
        }
        return result;
    }
}
