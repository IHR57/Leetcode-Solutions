class Solution {
    public boolean isValidTriangle(int a, int b, int c) {
        if(a + b > c && b + c > a && c + a > b) 
            return true;
        return false;
    }
    
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 3; i >= 0; i--) {
            if(isValidTriangle(nums[i], nums[i+1], nums[i+2])) {
                return nums[i] + nums[i+1] + nums[i+2];
            }
        }
        
        return 0;
    }
}