class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length <= 1) {return new int[] {-1, -1};}
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[] {map.get(difference), i};
            }
            else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }
}
