class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int cols = obstacleGrid[0].length;
        int row = obstacleGrid.length;
        int[][] dp = new int[cols][row];
        for (int i =0; i< row; i++) {
            if(obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
                break;
            }
        }
        
        for (int i =0; i< cols; i++) {
            if(obstacleGrid[0][i] == 1) {
                dp[0][i] = 0;
                break;
            }
        }
         for(int i =1; i< row; i++) {
             for(int j =1; j< cols; j++) {
                 if(obstacleGrid[i][j] == 1) {
                     dp[i][j] = 0;
                 }else {
                    dp[i][j] = dp[i-1][j] +  dp[i][j-1];
                 }
             }
         }
        
        return dp[row-1][cols-1];
    }
}