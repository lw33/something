package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-02 20:15:05
 *
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 **/
public class P33_GetUglyNumber_Solution {

    public int GetUglyNumber_Solution(int index) {

        if (index < 7) {
            return index;
        }

        int cur2 = 0;
        int cur3 = 0;
        int cur5 = 0;
        int cur = 1;
        int[] uglys = new int[index];
        uglys[0] = 1;
        for (int i = 1; i < index ; i++) {

            uglys[i] = Math.min(Math.min(uglys[cur2] * 2, uglys[cur3] * 3), uglys[cur5] * 5);

            while (uglys[i] == uglys[cur2] * 2) {
                cur2++;
            }

            while (uglys[i] == uglys[cur3] * 3) {
                cur3++;
            }

            while (uglys[i] == uglys[cur5] * 5) {
                cur5++;
            }
            cur = uglys[i];
        }
        return cur;
    }

    @Test
    public void test() {
        for (int i = 1; i < 1695; i++) {
            System.out.print(this.GetUglyNumber_Solution(i) + ", ");
        }
    }
}
