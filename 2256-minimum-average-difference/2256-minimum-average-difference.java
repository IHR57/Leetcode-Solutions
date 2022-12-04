class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long[] prefAvg = new long[n+1];
        prefAvg[0] = 0;
        
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            prefAvg[i+1] = sum / (i + 1);
        }
        
        long ans = prefAvg[n];
        int idx = n - 1;
        
        sum = 0;
        for(int i = n - 1; i >= 1; i--) {
            sum += nums[i];
            long diff = Math.abs(sum / (n - i) - prefAvg[i]);
            if(diff <= ans) {
                ans = diff;
                idx = i - 1;
            }
        }
        
        return idx;
    }
}