class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums.length < 3) {return result;}
        Arrays.sort(nums);
        int i = 0;
        int j = i;
        int k = nums.length;
        while(i <= nums.length - 3) {
            if (i > 0 && nums[i-1] == nums[i]) {
                i++;
                continue;
            }
            j = i + 1;
            k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(
                        Arrays.asList(nums[i], nums[j], nums[k])
                    );
                j++;
                k--;
                while (j < k && nums[j - 1] == nums[j]) {j++;}
                while (j > k && k > 0 && nums[k + 1] == nums[k]) {k--;}
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            i++; 
        }

        return result;
    }
}
