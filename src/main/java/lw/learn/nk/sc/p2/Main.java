package lw.learn.nk.sc.p2;

import java.util.Scanner;

/**
 * @Author lw
 * @Date 2019-03-18 17:05:35
 **/
public class Main {

    /**
     * 时间复杂度 O(n^2)
     * 空间复杂度 O(1)
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int i = 0;
        while (i < arr.length - 2) {
            int l = i + 1;
            int r = arr.length - 1;
            int tmpT = target - arr[i];
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum == tmpT) {
                    System.out.println(i + " " + l + " " + r);
                    return;
                }
                if (sum >= tmpT) {
                    while (arr[r--] == arr[r] && l < r) ;
                }
                if (sum <= tmpT) {
                    while (arr[l] == arr[++l] && l < r) ;
                }
            }
            while (arr[i] == arr[++i] && i < arr.length - 2) ;
        }
        System.out.println(-1 + " " + -1 + " " + -1);
    }
}
