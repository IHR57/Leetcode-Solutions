class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        int[] dirx = new int[] {1, -1, 0, 0};
        int[] diry = new int[] {0, 0, 1, -1};
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '#';
        
        while(!q.isEmpty()) {
            int[] top = q.poll();
            for(int i = 0; i < 4; i++) {
                int tx = top[0] + dirx[i];
                int ty = top[1] + diry[i];
                if(tx >= 0 && tx < n && ty >= 0 && ty < m && maze[tx][ty] == '.') {
                    if(tx == 0 || tx == n - 1 || ty == 0 || ty == m - 1)
                        return top[2] + 1;
                    q.offer(new int[] {tx, ty, top[2] + 1});
                    maze[tx][ty] = '#';
                }
            }
        }
        
        return -1;
    }
}