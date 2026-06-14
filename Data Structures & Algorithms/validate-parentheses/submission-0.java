class Solution {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> openClosePairMap = new HashMap<>() {{
            put('(', ')');
            put('[', ']');
            put('{', '}');
        }};

        for (char c : str.toCharArray()) {
            // If opening → push
            if (openClosePairMap.containsKey(c)) {
                stack.push(c);
            } 
            // If closing → check stack
            else {
                if (stack.isEmpty()) return false; // no opener
                char open = stack.pop();
                if (openClosePairMap.get(open) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty(); // all matched
    }
}
