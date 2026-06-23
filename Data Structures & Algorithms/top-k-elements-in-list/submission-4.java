class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int []result = new int[k];
        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();
        for(int n: nums) {
            freqCount.put(n, freqCount.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> maxFreqCountHeap
         = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);


        int maxHeapSize = k;
        for(int num: freqCount.keySet()) {
            maxFreqCountHeap.offer(
                new int[]{
                    num,
                    freqCount.get(num)
                }
            );
            if(maxFreqCountHeap.size() > k){
                maxFreqCountHeap.poll();
            }
        }

        for(int i = 0; i < k; i++){
            result[i] = maxFreqCountHeap.poll()[0];
        }

        return result;
    }   
}
