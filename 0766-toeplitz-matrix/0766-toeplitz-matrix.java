class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        Boolean[][] vis = new Boolean[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == null) {
                    int tx = i;
                    int ty = j;
                    while(tx < n && ty < m) {
                        if(matrix[tx][ty] != matrix[i][j])
                            return false;
                        vis[tx][ty] = true;
                        tx += 1;
                        ty += 1;
                    }
                }
            }
        }
        
        return true;
    }
}