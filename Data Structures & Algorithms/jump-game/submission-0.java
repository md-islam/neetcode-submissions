class Solution {
    public boolean canJump(int[] nums) {
        int furthestReach = 0;
        for(int i = 0; i < nums.length; i++){
            if(i > furthestReach){
                return false;
            }   
            furthestReach = Math.max(furthestReach, nums[i] + i);
        }
        if(furthestReach >= nums.length - 1) {
            return true;
        }
        return false;
    }
}