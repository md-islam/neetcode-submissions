/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> endTimeMinHeap = new PriorityQueue<Integer>();
        for(Interval interval: intervals){
            if(!endTimeMinHeap.isEmpty() && 
            endTimeMinHeap.peek() <= interval.start){
                endTimeMinHeap.poll();
            } 
            endTimeMinHeap.offer(interval.end);
        }
        return endTimeMinHeap.size();
    }
}
