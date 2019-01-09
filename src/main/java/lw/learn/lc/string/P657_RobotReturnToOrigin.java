package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-08 23:53:41
 **/
public class P657_RobotReturnToOrigin {

    public boolean judgeCircle666(String moves) {
        int[] temp = new int[91];
        char[] chs = moves.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            temp[chs[i]]++;
        }
        return temp[82] == temp[76] && temp[85] == temp[68];
    }
    public boolean judgeCircle(String moves) {
        char[] mf = moves.toCharArray();
        int h = 0;
        int v = 0;
        for (char c : mf) {
            switch (c) {
                case 'U':
                    ++v;
                    break;
                case 'R':
                    ++h;
                    break;
                case 'L':
                    --h;
                    break;
                case 'D':
                    --v;
            }
        }
        return h == 0 && v == 0;
    }


    @Test
    public void test() {
        String s = "LL";
        System.out.println(this.judgeCircle(s));
    }
}
