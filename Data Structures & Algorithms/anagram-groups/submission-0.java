class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> tracker = new HashMap();
        for (String currentStringInList : strs) {
            char[] charArray = currentStringInList.toCharArray();
            Arrays.sort(charArray);
            String sortedString = String.valueOf(charArray);
            if (tracker.containsKey(sortedString)) {
                List<String> currentList = tracker.get(sortedString);
                currentList.add(currentStringInList);
                tracker.put(sortedString, currentList);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(currentStringInList);
                tracker.put(sortedString, newList);
            }
        }
        for(Map.Entry<String, List<String>> entrySet: tracker.entrySet()) {
            result.add(entrySet.getValue());
        }
        return result;
    }
}
