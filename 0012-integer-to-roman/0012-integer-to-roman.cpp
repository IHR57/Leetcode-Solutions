class Solution {
public:
    string intToRoman(int num) {
        
        int nums[]= {1,4,5,9,10,40,50,90,100,400,500,900,1000};
        string str[]={"I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M"};
        
        int pos = 12;
        string ans="";
        
        while(num > 0)
        {
            int x = num / nums[pos];
            num = num % nums[pos];
            while(x--)
                ans += str[pos];
            pos--;
        }
        
        return ans;
    }
};