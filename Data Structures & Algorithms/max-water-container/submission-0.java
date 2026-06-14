class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        if (heights.length < 2) {
            return maxArea;
        }
        int start = 0;
        int end = heights.length - 1;
        while (start < end) {
            int width = end - start;
            int minLength = Math.min(heights[start], heights[end]);
            int currentArea = width * minLength;
            maxArea = Math.max(currentArea, maxArea);
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end --;
            }
        }
        return maxArea;   
    }
}
