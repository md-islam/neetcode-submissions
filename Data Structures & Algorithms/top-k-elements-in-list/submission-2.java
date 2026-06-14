class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int []result = new int[k];
        Map<Integer, Integer> freqCount = new HashMap<Integer, Integer>();

        //Build a Frequence Count Map
        for(int i = 0; i < nums.length; i++){
            freqCount.put(nums[i], freqCount.getOrDefault(nums[i], 0) + 1);
        }

        //Maintain a heap of size k
        //MinHeap compare by Frequency 
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> entry: freqCount.entrySet()){
            minHeap.add(entry);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        for (int i = k - 1; i >=0 ; i--) {
            result[i] = minHeap.poll().getKey();
        }
        return result;
    }
}
