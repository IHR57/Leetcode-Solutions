class Solution {
public:
    vector<string> topKFrequent(vector<string>& words, int k) {
        unordered_map<string, int> wordMap;
        for(string word: words) {
            wordMap[word]++;
        }
        
        auto comp = [&] (const pair<string, int> a, const pair<string, int> b) {
            return a.second > b.second || (a.second == b.second && a.first < b.first);
        };
        
        typedef priority_queue<pair<string, int>, vector<pair<string, int> >, decltype(comp)> PQ;
        PQ pq(comp);
        
        for(auto word : wordMap) {
            pq.emplace(word.first, word.second);
            if(pq.size() > k) {
                pq.pop();
            }
        }
        
        vector<string> ans;
        while(!pq.empty()) {
            ans.push_back(pq.top().first);
            pq.pop();
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};