class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> duplicateTracker = new HashSet<Integer>();
        for (int num : nums) {
            if (duplicateTracker.contains(num)) {
                return true;
            }
            duplicateTracker.add(num);
        }
        return false;
    }
}
