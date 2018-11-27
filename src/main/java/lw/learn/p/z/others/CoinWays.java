package lw.learn.p.z.others;


import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-27 17:42:47
 **/
public class CoinWays {

    public int coin1(int[] arr, int aim) {

        return 0;
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
