package lw.learn.lc.sort;

import lw.learn.utils.LCUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-22 21:13:37
 **/
public class P315_CountOfSmallerNumbersAfterSelf {

    // 结果
    List<Integer> res;
    // arr(被归并的数组) 与 help(归并过程中的辅助数组) 为 [n][2] 大小的数组
    // 期中每行 0 位置记录索引 1 位置记录对应索引在原数组中的值
    // 整个归并的过程 通过每一行的 1 位置来进行比较
    // 同时保持索引 以便在填左边数时 能通过索引给 res 相应位置添加结果
    int[][] arr, help;

    public List<Integer> countSmaller(int[] nums) {
        res = new ArrayList<>(nums.length);
        if (nums.length == 0) {
            return res;
        }
        arr = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            // 初始化 arr
            arr[i] = new int[]{i, nums[i]};
            // 初始化结果
            res.add(0);
        }
        help = new int[nums.length][2];
        // 归并
        mergeSort(0, nums.length - 1);
        return res;
    }

    private void mergeSort(int l, int r) {
        if (l == r) {
            return;
        }
        int m = (r + l) >> 1;
        mergeSort(l, m);
        mergeSort(m + 1, r);

        for (int p1 = l, p2 = m + 1, i = l; p1 <= m || p2 <= r; i++) {
            // 填左边数时
            if (p2 > r || (p1 <= m && arr[p1][1] <= arr[p2][1])) {
                // help[i] = arr[p1]
                help[i][0] = arr[p1][0];
                help[i][1] = arr[p1][1];
                // p2 - (m + 1) 为 p1 大于 右边的数个数
                // res.get(arr[p1][0]) 相应位置为上一次归并结果
                int great = p2 - (m + 1);
                if (great > 0) {
                    res.set(arr[p1][0], res.get(arr[p1][0]) + great);
                }
                p1++;

                // 填右边数
            } else {

                // help[i] = arr[p2]
                help[i][0] = arr[p2][0];
                help[i][1] = arr[p2][1];
                p2++;
            }
        }
        // 将 help 数组对应位置赋值给 arr
        for (int i = l; i <= r; i++) {
            arr[i][0] = help[i][0];
            arr[i][1] = help[i][1];
        }
    }

    @Test
    public void test() {
        //int[] arr = LCUtils.stringToIntegerArray("[5,2,6,1]");
        int[] arr = LCUtils.stringToIntegerArray("[-1,0,-1]");
        System.out.println(this.countSmaller(arr));
    }
}
