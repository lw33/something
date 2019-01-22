package lw.learn.lc.dp;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-22 11:51:57
 **/
public class P312_BurstBalloons {

    public int maxCoins(int[] nums) {

        boolean[] visited = new boolean[nums.length];

        int[] help = new int[nums.length + 2];
        help[0] = 1;
        help[nums.length + 1] = 1;
        System.arraycopy(nums, 0, help, 1, nums.length);

        //return process(help, 1, nums.length);
        //return process(nums, visited, nums.length);
        int[][] res = new int[help.length][help.length];
        return process(help, 1, nums.length, res);
    }

    /**
     * 打掉 i
     *
     * @param arr
     * @param l
     * @param r
     * @param res
     * @return
     */
    private int process(int[] arr, int l, int r, int[][] res) {
        if (l == r) {
            return arr[l] * arr[l - 1] * arr[l + 1];
        }
        if (res[l][r] != 0) {
            return res[l][r];
        }
        int mul = arr[l - 1] * arr[r + 1];
        int max = Math.max(
                arr[l] * mul + process(arr, l + 1, r, res),
                arr[r] * mul + process(arr, l, r - 1, res)
        );
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max,
                    arr[i] * mul + process(arr, l, i - 1, res) + process(arr, i + 1, r, res)
            );
        }
        res[l][r] = max;
        return max;
    }

    public int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l] * arr[l - 1] * arr[l + 1];
        }
        int mul = arr[l - 1] * arr[r + 1];
        int max = Math.max(
                arr[l] * mul + process(arr, l + 1, r),
                arr[r] * mul + process(arr, l, r - 1)
        );
        for (int i = l + 1; i < r; i++) {
            max = Math.max(max,
                    arr[i] * mul + process(arr, l, i - 1) + process(arr, i + 1, r)
            );
        }
        return max;
    }

    public int processDp(int[] arr) {

        return 0;
    }

    /**
     * 回溯法 复杂度太高。。。
     *
     * @param nums
     * @param visited
     * @param n
     * @return
     */
    public int process(int[] nums, boolean[] visited, int n) {
        if (n == 0) {
            return 0;
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                int left = 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (!visited[j]) {
                        left = nums[j];
                        break;
                    }
                }
                int right = 1;
                for (int j = i + 1; j < nums.length; j++) {
                    if (!visited[j]) {
                        right = nums[j];
                        break;
                    }
                }
                max = Math.max(max, left * right * nums[i] + process(nums, visited, n - 1));
                visited[i] = false;
            }
        }
        return max;
    }

    @Test
    public void test() {
        //int[] ints = JSON2Java.json2intArray("[7,9,8,0,7,1,3,5,5,2,3,3]");
        int[] ints = LCUtils.stringToIntegerArray("[8,3,4,3,6,6,2,2]");
        System.out.println(this.maxCoins(ints));
    }
}
