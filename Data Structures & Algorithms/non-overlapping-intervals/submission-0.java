class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int totalIntervals = intervals.length;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] last = result.remove(result.size() - 1);
            if(last[1] > current[0]){ //Case 1: Overlap
                if(last[1] > current[1]){
                    result.add(current);
                } else {
                    result.add(last);
                }
            } else {
                result.add(last);
                result.add(current);
            }
        }
        return totalIntervals - result.size();
    }
}
