class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    public void helper(int[]nums, 
                        int index, 
                        int target, 
                        List<Integer> path, 
                        List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        if(target < 0) {
            return;
        }
        if(index == nums.length){
            return;
        }
        //Take current
        path.add(nums[index]);
        helper(nums, index, target - nums[index], path, result);
        //remove one - Undo Change - makes it backtracking
        //skip current, move on
        path.remove(path.size()-1);
        helper(nums, index+1, target, path, result);
    }
}