class Solution {
public:
    int maxLength(vector<string>& arr) {
        int n = arr.size();
        int ans = 0;
        for(int i = 0; i < (1<<n); i++) {
            vector<int> vis(26, 0);
            bool flag = false;
            int cnt = 0;
            for(int j = 0; j < n; j++) {
                if(i & (1<<j)) {
                    for(int k = 0; k < arr[j].size(); k++) {
                        if(!vis[arr[j][k]-'a']) {
                            vis[arr[j][k]-'a'] = 1;
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if(flag)
                        break;
                    cnt += (int) arr[j].size();
                }
                if(flag)
                    break;
            }
            if(!flag)
                ans = max(ans, cnt);
        }
        
        return ans;
    }
};