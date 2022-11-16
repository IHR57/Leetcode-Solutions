/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        long low = 1, high = n;
        long mid = -1;
        while(low <= high) {
            mid = (low + high + 1) / 2;
            if(guess((int) mid) == 0)
                return (int) mid;
            else if(guess((int) mid) == -1) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return (int) mid;
    }
}