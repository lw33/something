package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-01-21 22:55:42
 **/
public class P367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num < 2) {
            return true;
        }

       /* return !IntStream.rangeClosed(0, num)
                .filter(i -> i * i == num)
                .findAny().isEmpty();*/
        for (int i = 0; i < num/2; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
