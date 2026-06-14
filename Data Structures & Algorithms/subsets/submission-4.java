class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    public void helper(int[]nums, int index, List<Integer> path, 
                        List<List<Integer>> result){
        if(index == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        //Take current
        path.add(nums[index]);
        helper(nums, index+1, path, result);
        //remove one - Undo Change - makes it backtracking
        //skip current
        path.remove(path.size()-1);
        helper(nums, index+1, path, result);
    }
}
