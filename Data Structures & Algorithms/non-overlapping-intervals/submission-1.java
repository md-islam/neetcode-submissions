class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int removals = 0;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if(currentStart < prevEnd) {
                removals++;
                prevEnd = Math.min(prevEnd, currentEnd);
            } else {
                prevEnd = currentEnd;
            }
        }
        return removals;
    }
}
