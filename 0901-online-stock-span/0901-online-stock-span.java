class StockSpanner {
    Stack<int[]> stack = new Stack<>();
    
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int ans = 0;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }
        stack.push(new int[] {price, ans + 1});
        return ans + 1;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */