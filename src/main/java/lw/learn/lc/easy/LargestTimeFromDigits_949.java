package lw.learn.lc.easy;

import org.junit.Test;


/**
 * @Author lw
 * @Date 2018-12-09 13:26:50
 **/
public class LargestTimeFromDigits_949 {

    public String largestTimeFromDigits(int[] A) {
        int max = 0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 2)
                continue;
            sb.append(A[i]);
            for (int j = 0; j < A.length; j++) {
                if (i == j || (A[i] == 2 && A[j] > 3))
                    continue;
                sb.append(A[j]);
                for (int k = 0; k < A.length; k++) {
                    if (k == j || k == i || A[k] > 5)
                        continue;
                    sb.append(A[k]);
                    for (int l = 0; l < A.length; l++) {
                        if (l != i && l != k && l != j) {
                            sb.append(A[l]);
                            int num = Integer.parseInt(sb.toString());
                            max = Math.max(num, max);
                            sb.delete(3, sb.length());
                            flag = true;
                        }
                    }
                    sb.delete(2, sb.length());
                }
                sb.delete(1, sb.length());
            }
            sb.delete(0, sb.length());
        }
        if (!flag) {
            return "";
        }
        if (max == 0) {
            return "00:00";
        }
        sb.append(max);
        if (sb.length() < 4) {
            while (sb.length() != 4) {
                sb.insert(0, 0);
            }
        }
        sb.insert(2, ":");
        return sb.toString();
    }


    @Test
    public void test() {
        int[] arr = {1, 9, 6, 0};
        System.out.println(this.largestTimeFromDigits(arr));
    }
}
