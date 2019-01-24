package lw.learn.lc.math;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-23 23:37:17
 **/
public class P60_PermutationSequence {

    /**
     * 将排列分段 从上到下找到每个段所在的位置 再将其分段一直找
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        List<Integer> candidates= new ArrayList<>();
        int[] pc = new int[n+1];
        pc[0] = 1;
        for (int i = 1; i <= n; i++) {
            candidates.add(i);
            pc[i] = pc[i - 1] * i;
        }
        if (k > pc[n]) {
            return "";
        }
        --k;
        StringBuilder sb = new StringBuilder();
        while (!candidates.isEmpty()){
            int base = pc[n-1];
            int segment = k / base;
            k = k % base;
            sb.append(candidates.get(segment));
            candidates.remove(segment);
            --n;
        }
        return sb.toString();
    }


    @Test
    public void test() {
        System.out.println(this.getPermutation(3, 6));
    }
}
