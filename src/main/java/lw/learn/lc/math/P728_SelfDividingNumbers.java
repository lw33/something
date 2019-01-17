package lw.learn.lc.math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-17 23:31:18
 **/
public class P728_SelfDividingNumbers {

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = IntStream.rangeClosed(left, right).parallel()
                .filter(P728_SelfDividingNumbers::isSelfDivNum)
                .boxed()
                .collect(Collectors.toList());
        return res;
    }

    public static List<Integer> selfDividingNumbersNormal(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivNum(i)) {
                res.add(i);
            }
        }
        return res;
    }

    public static boolean isSelfDivNum(int num) {
        int tmp = num;
        while (num > 0) {
            int mod = num % 10;
            if (mod == 0 || tmp % mod != 0) {
                return false;
            }
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        int s = 0;
        int e = 100000000;
        long start = System.currentTimeMillis();
        selfDividingNumbers(s, e);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        start = System.currentTimeMillis();
        selfDividingNumbersNormal(s, e);
        end = System.currentTimeMillis();
        System.out.println(end - start);

    }
}
