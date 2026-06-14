class Solution {
    public int climbStairs(int n) {
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int n) {
        if(n < 2) {
            return 1;
        }
        int oneBack = 1;
        int twoBack = 1;
        for(int i = 2; i <= n; i++) {
            int current = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }
}
