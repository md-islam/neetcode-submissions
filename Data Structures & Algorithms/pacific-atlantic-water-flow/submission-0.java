class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        boolean[][] pacificReachable = new boolean[rows][columns];
        boolean[][] atlanticReachable = new boolean[rows][columns];
        
        // Pacific: top row

        for (int column = 0; column < columns; column++) {

            helper(heights, 0, column, pacificReachable);

        }

        // Pacific: left column

        for (int row = 0; row < rows; row++) {

            helper(heights, row, 0, pacificReachable);

        }

        // Atlantic: bottom row

        for (int column = 0; column < columns; column++) {

            helper(heights, rows - 1, column, atlanticReachable);

        }

        // Atlantic: right column

        for (int row = 0; row < rows; row++) {

            helper(heights, row, columns - 1, atlanticReachable);

        }

       

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(pacificReachable[i][j] == true && 
                atlanticReachable[i][j] == true) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    public void helper(int[][] heights, 
                        int row, 
                        int column, 
                        boolean[][] reachable) {
        //base case
        if(reachable[row][column] == true) {
            return;
        }

        reachable[row][column] = true;

        int[][] directions = {
            {1,0}, //up
            {-1,0}, //down
            {0,-1}, //left
            {0,1} //right
        };
        for(int[] direction: directions){
            int newColumn = column + direction[1];
            int newRow = row + direction[0];

            boolean outOfBounds = newColumn >= heights[0].length ||
                newColumn < 0 || 
                newRow < 0 || 
                newRow >= heights.length;

            if (!outOfBounds && heights[newRow][newColumn] >= heights[row][column]) {
                helper(heights, newRow, newColumn, reachable);
            }
        }
    }



}
