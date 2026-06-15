class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<int[]>();
        for(int[] current: intervals){
            //Case A: current way before new interval
            if(current[1] < newInterval[0]){
                result.add(current);
            } else if (newInterval[1] < current[0]) {
                //Case B: new interval way before current intervals
                result.add(newInterval);
                newInterval = current;
            } else {
                //Case C: overlap case
                newInterval[0] = Math.min(newInterval[0], current[0]);
                newInterval[1] = Math.max(newInterval[1], current[1]);
            }         
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);       
    }
}