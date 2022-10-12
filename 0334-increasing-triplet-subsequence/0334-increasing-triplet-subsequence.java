class Solution {
    public boolean increasingTriplet(int[] nums) {
        int mn = Integer.MAX_VALUE;
        int md = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > md) {
                return true;
            } else if(nums[i] > mn && nums[i] < md) {
                md = nums[i];
            } else if(nums[i] < mn) {
                mn = nums[i];
            }
        }
        
        return false;
    }
}