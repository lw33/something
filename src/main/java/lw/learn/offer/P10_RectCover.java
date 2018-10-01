package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 17:14:38
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 **/
public class P10_RectCover {

    public int RectCover(int target) {

        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }

        int[] covers = new int[target + 1];
        covers[0] = 1;
        covers[1] = 1;
        for (int i = 2; i < target+1; i++) {
            covers[i] = covers[i - 1] + covers[i - 2];
        }
        return covers[target];
    }

}
