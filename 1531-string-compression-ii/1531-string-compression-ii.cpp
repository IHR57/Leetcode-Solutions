class Solution {
public:
    int dp[105][105], n;
    int INF = 1e9;
    
    int getLen(int val) {
        if(val == 1)
            return 0;
        if(val > 1 && val <= 9)
            return 1;
        if(val >= 10 && val <= 99)
            return 2;
        if(val >= 100)
            return 3;
        
        return 0;
    }
    
    int solve(int pos, int k, string& str) {
        if(k < 0) 
            return INF;
        if(pos >= n || n - pos <= k)
            return 0;
        
        if(dp[pos][k] != -1)
            return dp[pos][k];
        
        int ret = INF;

        vector<int> freq(26, 0);
        int maxCnt = 0;
        for(int j = pos; j < n; j++) {
            maxCnt = max(maxCnt, ++freq[str[j] - 'a']);
            ret = min(ret, 1 + getLen(maxCnt) + solve(j + 1, k - (j - pos + 1 - maxCnt), str));
        }
        
        return dp[pos][k] = ret;
    }
    
    int getLengthOfOptimalCompression(string s, int k) {
        memset(dp, -1, sizeof(dp));
        
        n = s.size();
        int ans = solve(0, k, s);
        
        return ans;
    }
};