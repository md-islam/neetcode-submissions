class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        return climbStairsHelper(n);
    }

    private int climbStairsHelper(int n) {
        if(n < 0) {return 0;}
        if(n == 0 || n == 1) {return 1;}
        if(memo[n] != 0){
            return memo[n];
        }
        memo[n] = climbStairsHelper(n-1) + climbStairsHelper(n-2);
        return memo[n]; 
    }
}
