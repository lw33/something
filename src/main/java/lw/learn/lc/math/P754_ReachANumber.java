package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-12 19:34:13
 **/
public class P754_ReachANumber {
    /**
     * 将 sum 从 1 到 N 一直累加直到 sum == target 或
     * sum 大于 target 时 sum - target 为偶数
     * 因为 在向左走的时候 得消耗一个 n 再向右走的时候 得再消耗一个 n
     * 所以当它们差值为一个偶数时 刚好能走到
     * @param target
     * @return
     */
    public int reachNumber(int target) {

        if (target == 0)
            return 0;
        if (target < 0)
            target = -target;
        int sum = 0;
        int res = 1;
        while (true) {
            sum += res;
            if (sum == target || (sum > target && (sum - target) % 2 == 0)) {
                break;
            }
            res++;
        }
        return res;
    }
}
