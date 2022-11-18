class Solution {
    public boolean isUgly(int n) {
        if(n == 0)
            return false;
        int[] factors = new int[]{2, 3, 5};
        for(int i = 0; i < factors.length; i++) {
            while(n % factors[i] == 0) {
                n /= factors[i];
            }
        }
        
        return n == 1;
    }
}