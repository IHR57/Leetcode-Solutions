class Solution {
public:
    vector<int> graph[20005];

    int dfs(int u, int par, int target, vector<int>& vals) {
        int total = vals[u];
        for(int i = 0; i < graph[u].size(); i++) {
            int v = graph[u][i];
            if(v != par) {
                int res = dfs(v, u, target, vals);
                if(res != -1) {
                    total += res;
                } else {
                    return -1;
                }
            }
        }
        
        if(total == target)
            return 0;
        if(total > target)
            return -1;
        
        return total;
    }
    
    int componentValue(vector<int>& nums, vector<vector<int>>& edges) {
        int sum = 0, maxVal = -1;
        for(int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            maxVal = max(maxVal, nums[i]);
        }
        
        for(int i = 0; i < edges.size(); i++) {
            graph[edges[i][0]].push_back(edges[i][1]);
            graph[edges[i][1]].push_back(edges[i][0]);
        }
        
        vector<int> divisors;
        for(int i = 1; i * i <= sum; i++) {
            if(sum % i == 0) {
                divisors.push_back(i);
                if(sum / i != i)
                    divisors.push_back(sum / i);
            }
        }
        
        sort(divisors.begin(), divisors.end());
        
        for(int i = 0; i < divisors.size(); i++) {
            if(divisors[i] >= maxVal) {
                if(dfs(0, -1, divisors[i], nums) == 0) {
                    return sum / divisors[i] - 1;
                }
            }
        }
        
        return 0;
    }
};