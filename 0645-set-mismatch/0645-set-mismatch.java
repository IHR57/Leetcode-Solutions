class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        
        int[] ans = new int[2];
        int[] counter = new int[n+1];
        
        Arrays.fill(counter, 0);
        
        for(int i = 0; i < n; i++) {
            counter[nums[i]]++;
            if(counter[nums[i]] >= 2) {
                ans[0] = nums[i];
            }
        }
        
        for(int i = 1; i <= n; i++) {
            if(counter[i] == 0) {
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}