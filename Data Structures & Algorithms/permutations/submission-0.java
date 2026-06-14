class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, new ArrayList<Integer>(), result, visited);
        return result;
    }
    
    public void helper(int[]nums, 
                        List<Integer> path,
                        List<List<Integer>> result,
                        boolean[] visited) {

        if(path.size() == nums.length){
            result.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited[i]==true){
                continue;
            }
            visited[i] = true;
            path.add(nums[i]);            
            helper(nums, path, result, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }
}