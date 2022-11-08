class Solution {
    public boolean isBad(char a, char b) {
        if(a != b && Character.toLowerCase(a) == Character.toLowerCase(b))
            return true;
        return false;
    }
    
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
            int pos = sb.length() - 1;
            while(pos > 0) {
                if(isBad(sb.charAt(pos), sb.charAt(pos - 1))) {
                    sb.deleteCharAt(pos);
                    sb.deleteCharAt(pos - 1);
                    pos -= 2;
                } else {
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}