class Solution {
public:
    int isPalin[2005][2005];
    int dp[2005][2005], dist;
    
    bool isPalindrome(int i, int j, string& s) {
        if(i >= j)
            return true;
        if(isPalin[i][j] != -1)
            return isPalin[i][j];
        
        return isPalin[i][j] = (s[i] == s[j]) && isPalindrome(i + 1, j - 1, s);
    }
    
    int solve(int i, int j, string& s) {
        if(i > j)
            return 0;
        if(i >= s.size() || j >= s.size()) 
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int ret = 0;
        if(j - i + 1 >= dist) {
            if(isPalindrome(i, j, s)) {
                ret = max(ret, 1 + solve(j + 1, j + 1, s));
            }
        }
        ret = max(ret, solve(i + 1, j, s));
        ret = max(ret, solve(i, j + 1, s));
        
        return dp[i][j] = ret;
    }
    
    int maxPalindromes(string s, int k) {
        memset(isPalin, -1, sizeof(isPalin));
        memset(dp, -1, sizeof(dp));
        dist = k;
        
        return solve(0, 0, s);
    }
};