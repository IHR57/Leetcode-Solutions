class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        Map<Integer, Integer>[] cnt = new Map[n];
        
        for (int i = 0; i < n; i++) {
            cnt[i] = new HashMap<>(i);
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - (long) nums[j];
                if(diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE)
                    continue;
                int sum = cnt[j].getOrDefault((int) diff, 0);
                int origin = cnt[i].getOrDefault((int) diff, 0);
                cnt[i].put((int) diff, origin + sum + 1);
                ans += sum;
            }
        }
        
        return ans;        
    }
}