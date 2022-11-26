bool compare(pair<pair<int, int>, int>& A, pair<pair<int, int>, int>& B) {
        if(A.first.first == B.first.first)
            return A.first.second < B.first.second;
        return A.first.first < B.first.first;
}
class Solution {
public:
    int solve(int pos, vector<pair<pair<int, int>, int>>&vp, vector<int>& dp) {
        if(pos >= vp.size())
            return 0;
        if(dp[pos] != -1)
            return dp[pos];
        int ret = 0;
        int idx = lower_bound(vp.begin(), vp.end(), make_pair(make_pair(vp[pos].first.second, -1), -1)) - vp.begin();
        ret = vp[pos].second + solve(idx, vp, dp);
        ret = max(ret, solve(pos + 1, vp, dp));
        
        return dp[pos] = ret;
    }
    
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        vector<pair<pair<int, int>, int>> vp;
        int n = startTime.size();
        for(int i = 0; i < n; i++) {
            vp.push_back(make_pair(make_pair(startTime[i], endTime[i]), profit[i]));
        }
        
        sort(vp.begin(), vp.end(), compare);

        vector<int> dp(n + 1, -1);
        
        return solve(0, vp, dp);
    }
};