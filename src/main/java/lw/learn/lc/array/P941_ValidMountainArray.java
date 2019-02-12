package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-12 18:56:29
 **/
public class P941_ValidMountainArray {

    /**
     * 从两边开始找 找到最后那个数 是否相等
     *
     * @param A
     * @return
     */
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int lIndex = 0;
        int rIndex = A.length - 2;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                lIndex = i;
            } else if (A[i] == A[i - 1]) {
                return false;
            } else {
                break;
            }
        }
        if (lIndex > rIndex || lIndex == 0) {
            return false;
        }
        for (int i = A.length - 1; i > lIndex; i--) {
            if (A[i] < A[i - 1]) {
                rIndex = i - 1;
            } else if (A[i] == A[i - 1]) {
                return false;
            } else {
                break;
            }
        }
        return lIndex == rIndex;
    }
}
