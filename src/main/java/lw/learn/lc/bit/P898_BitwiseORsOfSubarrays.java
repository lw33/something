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

        }
        return hashSet.size();
    }

    @Test
    public void test() {
        int[] arr = {1, 1, 2};
        System.out.println(this.subarrayBitwiseORs(arr));
    }
}
