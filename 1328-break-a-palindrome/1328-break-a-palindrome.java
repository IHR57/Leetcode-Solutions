class Solution {
    public String breakPalindrome(String palindrome) {
        char[] charArray = palindrome.toCharArray();
        if(charArray.length < 2)
            return "";
        for(int i = 0; i < charArray.length / 2; i++) {
            if(charArray[i] != 'a') {
                charArray[i] = 'a';
                return String.valueOf(charArray);
            }
        }
        
        charArray[charArray.length-1] = 'b';
        
        return String.valueOf(charArray);
    }
}