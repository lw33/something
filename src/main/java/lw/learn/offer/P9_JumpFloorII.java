package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 17:11:33
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 **/
public class P9_JumpFloorII {

    public int JumpFloorII(int target) {

        if (target == 0) {
            return 0;
        }

        if (target == 1) {
            return 1;
        }

        int[] kinds = new int[target + 1];
        kinds[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < i; j++) {
                kinds[i] += kinds[j];
            }
        }
        return kinds[target];
    }
}
