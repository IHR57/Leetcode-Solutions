class Solution {
    public int minDifficulty(int[] jobDifficulty, int day) {
        int n = jobDifficulty.length, maxd;
        if (n < day) 
            return -1;
        int[] dp = new int[n + 1];
        
        for (int i = n - 1; i >= 0; --i)
            dp[i] = Math.max(dp[i + 1], jobDifficulty[i]);
        
        for (int d = 2; d <= day; d++) {
            for (int i = 0; i <= n - d; ++i) {
                int maxVal = 0;
                dp[i] = Integer.MAX_VALUE;
                for (int j = i; j <= n - d; ++j) {
                    maxVal = Math.max(maxVal, jobDifficulty[j]);
                    dp[i] = Math.min(dp[i], maxVal + dp[j + 1]);
                }
            }
        }
        return dp[0];
    }
}