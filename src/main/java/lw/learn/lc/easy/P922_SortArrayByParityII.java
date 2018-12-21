package lw.learn.lc.easy;

/**
 * @Author lw
 * @Date 2018-12-21 01:13:07
 **/
// FIXME 2018/12/21  待优化
public class P922_SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        int[] newArr = new int[A.length];
        int oindex = 1;
        int eindex = 0;
        for (int i : A) {
            if (i % 2 == 0) {
                newArr[eindex++] = i;
                eindex++;
            } else {
                newArr[oindex++] = i;
                oindex++;
            }
        }
        return newArr;
    }
}
