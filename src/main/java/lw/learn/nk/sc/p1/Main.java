package lw.learn.nk.sc.p1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Author lw
 * @Date 2019-03-18 17:05:21
 **/
public class Main {

    /**
     * 时间复杂度为 O(n)
     * 空间复杂度为 O(n)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        System.out.println(max);
    }
}
