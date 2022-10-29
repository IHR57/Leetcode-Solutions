class Solution {
public:
    int earliestFullBloom(vector<int>& plantTime, vector<int>& growTime) {
        int ans = INT_MIN;
        vector<pair<int, int>> vp;
        
        for(int i = 0; i < plantTime.size(); i++) {
            vp.push_back({growTime[i], plantTime[i]});
        }
        
        sort(vp.rbegin(), vp.rend());
        
        int curr = 0;
        for(int i = 0; i < vp.size(); i++) {
            curr += vp[i].second;
            int bTime = curr + vp[i].first;
            ans = max(ans, bTime);
        }
        
        return ans;
    }
};