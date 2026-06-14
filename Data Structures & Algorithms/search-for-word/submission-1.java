class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helper(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean helper(char[][]board, String word, int i, int j, int wordIndex){
        if(wordIndex == word.length()){
            return true;
        }
        if(outOfBounds(board, i, j) || board[i][j] != word.charAt(wordIndex)){
            return false;
        }
        char original = board[i][j];
        board[i][j] = '#';
        boolean found = helper(board, word, i+1, j, wordIndex+1) || 
        helper(board, word, i-1, j, wordIndex+1) || 
        helper(board, word, i, j+1, wordIndex+1) || 
        helper(board, word, i, j-1, wordIndex+1); 
        board[i][j] = original;
        return found;
    }

    public boolean outOfBounds(char[][]board, int i, int j){
        return i < 0 || i >= board.length || j < 0 || j >= board[0].length;
    }
}
