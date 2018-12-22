package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-22 21:59:16
 **/
public class P374_GuessNumberHigherOrLower {

    public int guessNumber(int n) {

        int start = 1;
        int end = n;
        while (end >= start) {
            int mid = start + ((end - start) >> 1);
            int guess = guess(mid);
            if (guess == 0) {
                return mid;
            } else if (guess == 1) {
                start = mid + 1;
            }  else {
                end = mid - 1;
            }
        }
        return 1;
    }

    private int guess(int num) {
        return 0;
    }
}
