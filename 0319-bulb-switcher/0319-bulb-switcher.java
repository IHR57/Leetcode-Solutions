class Solution {
    public int bulbSwitch(int n) {
        int cnt = 0;
        for(long i = 1; 1L * i * i <= n; i++) {
            cnt++;
        }
        
        return cnt;
    }
}