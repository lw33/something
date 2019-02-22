package lw.learn.lc.greedy;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-22 11:19:19
 **/
public class P134_GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 && cost.length == 0) return 0;
        if (gas.length != cost.length) return -1;
        int sum = 0;
        int start = 0;
        int rest = 0;
        for (int i = 0; i < gas.length; i++) {
            int sub = gas[i] - cost[i];
            sum += sub;
            rest += sub;
            if (sum < 0) {
                start = i + 1;
                sum = 0;
            }
        }
        return rest < 0 ? -1 : start;
    }

    @Test
    public void test() {
        int[] arr1 = JSON2Java.json2intArray("[5,8,2,8]");
        int[] arr2 = JSON2Java.json2intArray("[6,5,6,6]");
        System.out.println(this.canCompleteCircuit(arr1, arr2));
    }
}
