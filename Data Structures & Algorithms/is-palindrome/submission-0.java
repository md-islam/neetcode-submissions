class Solution {
    public boolean isPalindrome(String s) {
        int pointerA = 0;
        int pointerB = s.length() - 1;
        while (pointerA < pointerB) {
            while(pointerA < pointerB && !alphaNum(s.charAt(pointerA))) pointerA++;
            while(pointerB > pointerA && !alphaNum(s.charAt(pointerB))) pointerB--;
            if (Character.toLowerCase(s.charAt(pointerA)) != Character.toLowerCase(s.charAt(pointerB))) {
                return false;
            }
            pointerA++;
            pointerB--;
        }
        return true;
    }

    private boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
