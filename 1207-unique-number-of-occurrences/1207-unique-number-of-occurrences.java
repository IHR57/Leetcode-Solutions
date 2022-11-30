class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int offset = 1000;
        int freq[] = new int[2 * offset + 1];
        
        for(int i = 0; i < arr.length; i++) {
            freq[arr[i] + offset]++;
        }
        
        Arrays.sort(freq);
        
        for(int i = 0; i < 2 * offset; i++) {
            if(freq[i] != 0 && freq[i] == freq[i+1]) {
                return false;
            }
        }
        
        return true;
    }
}