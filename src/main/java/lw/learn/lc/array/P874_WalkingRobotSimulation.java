package lw.learn.lc.array;

import lw.learn.utils.JSON2Java;
import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-03-05 22:40:06
 **/
public class P874_WalkingRobotSimulation {

    public static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 使用一个变量模拟方向      左右 进行加或减
     * 答案求的是整个行走的过程中最大的。。。
     *
     * @param commands
     * @param obstacles
     * @return
     */
    public int robotSim(int[] commands, int[][] obstacles) {
        if (commands.length == 0) {
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] + "_" + obstacle[1]);
        }
        int i = 0;
        int j = 0;
        int maxO = 0;
        int runD = 0;
        for (int command : commands) {
            if (command == -2) {
                if (runD == 0) {
                    runD = 4;
                }
                runD--;

            } else if (command == -1) {
                if (runD == 3) {
                    runD = -1;
                }
                runD++;
            } else {
                int[] go = d[runD];
                for (int k = 0; k < command; k++) {
                    if (set.contains((i + go[0]) + "_" + (j + go[1]))) {
                        break;
                    }
                    i += go[0];
                    j += go[1];
                    maxO = Math.max(i * i + j * j, maxO);
                }
            }
        }
        return maxO;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[4,-1,4,-2,4]");
        int[][] obstacles = JSON2Java.json2int2Array("[[2,4]]");
        System.out.println(this.robotSim(arr, obstacles));
    }
}
