class Solution {
public:
    string frequencySort(string s) {
        int n = s.size();
        vector<int> freq(256, 0);
        
        for(int i = 0; i < n; i++){
            freq[s[i]]++;
        }
        priority_queue<pair<int, int> > pq;
        for(int i = 0; i < 256; i++){
            pq.push(make_pair(freq[i], i));
        }
        
        string ans = "";
        while(!pq.empty()) {
            pair<int, int> temp = pq.top();
            pq.pop();
            for(int i = 0; i < temp.first; i++) {
                ans += (char) temp.second;
            }
        }
        
        return ans;
    }
};