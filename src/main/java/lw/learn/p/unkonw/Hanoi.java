package lw.learn.p.unkonw;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-22 21:11:21
 **/
public class Hanoi {

    // 1 ~ n
    // n on from
    public void hanoi(int n, String from, String to, String help) {
        if (n == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            hanoi(n - 1, from, help, to);
            System.out.println("move " + n + " from " + from + " to " + to);
            hanoi(n - 1, help, to, from);
        }
    }
    
    @Test
    public void test() {
        hanoi(3, "左", "右", "中");
    }
    
}
