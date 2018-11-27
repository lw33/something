package lw.learn.p.z.others;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-11-27 16:30:20
 **/
public class MaxXORSum {

    public int getMaxXoRSum1(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= i; j++) {
                int sum = 0;
                for (int k = j; k <= i; k++) {
                    sum ^= arr[k];
                }
                max = Math.max(sum, max);
            }
        }

        return max;
    }

    public int getMaxXoRSum2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int eor = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            max = Math.max(max, eor);
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, eor ^ dp[j - 1]);
            }
            dp[i] = eor;
        }
        return max;
    }

    class Node {
        Node[] nexts = new Node[2];
    }

    class NumTrie {

        Node head = new Node();

    }


    @Test
    public void test() {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(this.getMaxXoRSum1(arr));
        System.out.println(this.getMaxXoRSum2(arr));
    }


}