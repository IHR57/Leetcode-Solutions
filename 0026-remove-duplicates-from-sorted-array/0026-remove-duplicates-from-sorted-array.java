class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(!mp.containsKey(nums[i])) {
                nums[k++] = nums[i];
            }
            mp.put(nums[i], 1);
        }
        
        return mp.size();
    }
}