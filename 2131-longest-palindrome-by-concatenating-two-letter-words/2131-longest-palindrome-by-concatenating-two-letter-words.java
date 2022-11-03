class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            mp.put(words[i], mp.containsKey(words[i]) == true ? mp.get(words[i]) + 1 : 1);
        }
        
        int ans = 0, isOddExists = 0;
        
        for(Map.Entry<String, Integer> entry : mp.entrySet()) {
            if(entry.getValue() == -1)
                continue;
            String str = entry.getKey();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.reverse();
            
            if(!mp.containsKey(sb.toString()))
                continue;
            
            if(str.equals(sb.toString())) {
                if(entry.getValue() % 2 != 0) {
                    isOddExists = 1;
                }
                ans += (entry.getValue() / 2) * 4;
                continue;
            } 
            ans += Math.min(entry.getValue(), mp.get(sb.toString())) * 4;
            mp.put(sb.toString(), -1);
        }
        
        if(isOddExists == 1) ans += 2;
        
        return ans;
    }
}