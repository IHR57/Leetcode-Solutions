class Solution {
public:
    int n;
    
    int solve(vector<vector<int>>& a, vector<vector<int>>& b,int l,int d)
    {
        int r = 0, c;
        int lcnt = 0, rcnt = 0;
        for(int i = l; i < n; i++) {
            c = 0;
            for(int j = d; j < n; j++) {
                if(a[i][j] == 1 && a[i][j] == b[r][c])
                    lcnt++;
                if(a[i][c] == 1 && a[i][c] == b[r][j])
                    rcnt++;
                c++;
            }
            r++;
        }
        
        return max(lcnt, rcnt);
    }
    
    int largestOverlap(vector<vector<int>>& a, vector<vector<int>>& b) {
        n = a.size();
        int ans = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                ans = max(ans, solve(a, b, i, j));
                ans = max(ans, solve(b, a, i, j));
            }
        }
        
        return ans;
    }
};