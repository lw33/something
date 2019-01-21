package lw.learn.lc.math.fastest;

/**
 * @Author lw
 * @Date 2019-01-21 22:55:42
 **/
public class P367_ValidPerfectSquare {

    class Solution {
        public boolean isPerfectSquare(int num) {
            if(num < 0) return false;
            int left = 0 , right = 46340;
            while(left <= right){
                int mid = left + (right - left)/2;
                double sum = mid * mid;
                if(sum == num) return true;
                if(sum < num) left = mid + 1;
                else right = mid - 1;
            }
            return false;
        }
    }
}
