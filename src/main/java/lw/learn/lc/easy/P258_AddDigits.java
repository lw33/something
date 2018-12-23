package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-22 22:52:47
 **/
public class P258_AddDigits {

    public int addDigits(int num) {

        /*
        int result=num;
        while (result>=10){
            result=result%10 + result/10;
        }
        return result;
        */

        if (num < 10) {
            return num;
        }

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
}
