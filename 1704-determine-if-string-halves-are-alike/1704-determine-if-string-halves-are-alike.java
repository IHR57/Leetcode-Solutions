class Solution {
    public boolean isVowel(char ch) {
        if(Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i' || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u') {
            return true;
        }
        
        return false;
    }
    public boolean halvesAreAlike(String s) {
        int firstHalve = 0, secondHalve = 0;
        char[] charArray = s.toCharArray();
        
        int n = charArray.length;
        
        for(int i = 0; i < n / 2; i++) {
            if(isVowel(charArray[i]))
                firstHalve++;
            if(isVowel(charArray[n-i-1]))
                secondHalve++;
        }
        
        return firstHalve == secondHalve;
    }
}