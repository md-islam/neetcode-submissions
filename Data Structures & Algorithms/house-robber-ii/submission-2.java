class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {return nums[0];}
        return Math.max(
            robHelper(nums, 1, nums.length - 1),
            robHelper(nums, 0, nums.length - 2)
        );
    }

    public int robHelper(int[] house, int start, int end) {
        int oneHouseBackBestMoney = 0;
        int twoHouseBackBestMoney = 0;
        for(int i = start; i <= end; i++) {
            int moneyAtCurrentHouse = house[i];
            int currentBestMoneyAnswer = Math.max(twoHouseBackBestMoney + moneyAtCurrentHouse, 
                                oneHouseBackBestMoney);
            twoHouseBackBestMoney = oneHouseBackBestMoney;
            oneHouseBackBestMoney = currentBestMoneyAnswer;
        }
        return oneHouseBackBestMoney;
    }
}
