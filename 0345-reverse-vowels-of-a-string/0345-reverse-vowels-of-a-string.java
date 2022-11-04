class Solution {
    public boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
               ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U');
    }
    
    public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if(isVowel(ch) == true) {
                sb.append(ch);
            }
        }
        
        char[] charArray = s.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            if(isVowel(charArray[i])) {
                charArray[i] = sb.charAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() -1);
            }
        }
        
        return String.valueOf(charArray);
        
    }
}