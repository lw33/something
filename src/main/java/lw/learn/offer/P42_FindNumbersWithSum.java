package lw.learn.offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-10-03 12:32:20
 * <p>
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 **/
public class P42_FindNumbersWithSum {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> res = new ArrayList<>();

        int low = 0;
        int high = array.length - 1;
        int min = Integer.MAX_VALUE;

        while (high > low) {
            int product = array[low] * array[high];
            int add = array[low] + array[high];
            if (add == sum) {
                if (product < min) {
                    if (res.size() > 0) {
                        res.removeAll(res);
                    }
                    res.add(array[low]);
                    res.add(array[high]);
                    min = product;
                }
                low++;
                high--;
            } else if (add > sum) {
                high--;
            } else {
                low++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);
        res.add(1);
        res.add(1);
        System.out.println(res);
        res.removeAll(res);
        System.out.println(res);
    }
}
