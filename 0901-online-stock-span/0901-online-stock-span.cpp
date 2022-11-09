class StockSpanner {
public:
    StockSpanner() {
        
    }
    
    int next(int price) {
        int cnt = 0;
        while (!st.empty() && price >= st.top()) {
            cnt += mp[st.top()];
            st.pop();
        }
        st.push(price);
        mp[price] = (cnt + 1);
        
        return mp[price];
    }
    
    private:
        map<int, int> mp;
        stack<int> st;
    };

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner* obj = new StockSpanner();
 * int param_1 = obj->next(price);
 */