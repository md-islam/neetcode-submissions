class Solution {
    public boolean isValid(String s) {
        Stack<Character> openingParenthesis = new Stack<Character>();
        Map<Character, Character> openToClose = new HashMap<Character, Character>() {{
            put('{','}');
            put('(',')');
            put('[',']');
        }};
        for (Character c : s.toCharArray()){
            if(openToClose.containsKey(c)){
                //collect open parenthesis
                openingParenthesis.push(c);
            } else {
                //collect close parenthesis
                if(openingParenthesis.isEmpty()){
                    return false;
                } else {
                    Character lastOpeningParenthesis = openingParenthesis.peek();
                    if(openToClose.get(lastOpeningParenthesis).equals(c)) {
                        openingParenthesis.pop();
                    } else {
                        return false;
                    }
                }
            } 
        }
        return openingParenthesis.isEmpty();   
    }
}
