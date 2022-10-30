class Solution {
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];
        
		Queue<int[]> q = new LinkedList(); 
        q.add(new int[]{0, 0, k});
     
        int ans = 0;
        
        while(q.size() > 0){
            int sz = q.size();
			
            while(sz-- > 0){
                int[] top = q.remove();
                int x = top[0];
                int y = top[1];
                int tk = top[2];
                
                if(x == m - 1 && y == n - 1 && tk >= 0)   return ans;
                
                if(tk < 0 || visited[x][y][tk] == true)  continue;
                visited[x][y][tk] = true;
                
                if(x - 1 >= 0){
                    q.add(new int[]{x - 1, y, tk - grid[x - 1][y]});
                }
                if(x + 1 < m){
                    q.add(new int[]{x + 1, y, tk - grid[x + 1][y]});
                }
                if(y - 1 >= 0){
                    q.add(new int[]{x , y - 1, tk - grid[x][y - 1]});
                }
                if(y + 1 < n){
                    q.add(new int[]{x , y + 1, tk - grid[x][y + 1]});
                }
            }
            ans++;
        }
        
        return -1;
    }
}