package lw.learn.lc.bit;

import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2019-01-13 22:30:56
 **/
public class P898_BitwiseORsOfSubarrays {

    public int subarrayBitwiseORs(int[] A) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            hashSet.add(num);
            for (int j = i + 1; j < A.length; j++) {
                if (num == -1) {
                    break;
                }
                num |= A[j];
                hashSet.add(num);
            }
        }
        return hashSet.size();
    }

    public int subarrayBitwiseORsII(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        HashSet<Integer> hashSet = new HashSet<>();
        int[] memo = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            memo[i] = A[i];
            hashSet.add(memo[i]);
            for (int j = i + 1; j < A.length; j++) {
                int tmp = A[j] | memo[j - 1];
                if (i > 0 && tmp == memo[j]) {
                    break;
                } else {
                    memo[j] = tmp;
                }
                hashSet.add(memo[j]);
            }
        }
        return hashSet.size();
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2};
        System.out.println(this.subarrayBitwiseORs(arr));
        System.out.println(0xffffffff);
    }
}
