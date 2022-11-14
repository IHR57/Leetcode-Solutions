class Solution {
public:
    int n;
    void dfs(int u, vector<int>& vis, int & cnt, vector<vector<int>>& stones)  {
        vis[u] = 1;
        cnt++;
        for(int i = 0; i < n; i++) {
            if(!vis[i] && (stones[u][0] == stones[i][0] || stones[u][1] == stones[i][1])) {
                dfs(i, vis, cnt, stones);
            }
        }
    }
    
    int removeStones(vector<vector<int>>& stones) {
        n = stones.size();
        vector<int> vis(n + 1, 0);
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(!vis[i]) {
                int cnt = 0;
                dfs(i, vis, cnt, stones);
                ans += cnt - 1;
            }
        }
        
        return ans;
    }
};