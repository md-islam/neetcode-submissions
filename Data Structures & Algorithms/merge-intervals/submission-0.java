class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        ArrayList<int[]> result = new ArrayList<int[]>();
        result.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] lastIntervalPushed = result.get(result.size()-1);
            int[] currentInterval = intervals[i];
            if (lastIntervalPushed[1] >= currentInterval[0]){
                lastIntervalPushed[1] = Math.max(lastIntervalPushed[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);        
    }
}
