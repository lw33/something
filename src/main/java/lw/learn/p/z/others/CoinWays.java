package lw.learn.p.z.others;


import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-27 17:42:47
 **/
public class CoinWays {

    public int coin1(int[] arr, int aim) {
        if (aim == 0)
            return 1;
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; arr[0] * i <= aim; i++) {
            dp[0][arr[0] * i] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                int num = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    num += dp[i - 1][j - arr[i] * k];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }

    public int c1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += c1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    HashMap<String, Integer> map = new HashMap<>();
    public int c2(int[] arr, int index, int aim) {
        if (map.containsKey(index + "-" + aim)) {
            return map.get(index + "-" + aim);
        }
        if (aim == 0) {
            return 1;
        }
        if (aim < 0) {
            return 0;
        }
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += c2(arr, index + 1, aim - arr[index] * i);
            }
        }
        map.put(index + "-" + aim, res);
        return res;
    }


}
