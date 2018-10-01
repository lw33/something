package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 17:08:01
 * <p>
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 **/
public class P8_JumpFloor {

    public int JumpFloor(int target) {

        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int[] step = new int[target + 1];
        step[0] = 0;
        step[1] = 1;
        for (int i = 2; i < target+1; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[target];
    }

}
