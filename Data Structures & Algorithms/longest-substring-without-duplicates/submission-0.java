class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> tracker = new HashSet<Character>();
        int maxLength = 0;
        int left = 0; //shrinker
        for (int right = 0; right < s.length(); right++) {
            while(tracker.contains(s.charAt(right))) {
                tracker.remove(s.charAt(left));
                left++;
            }
            tracker.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
