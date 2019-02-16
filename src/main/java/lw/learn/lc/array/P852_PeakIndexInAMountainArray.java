package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-15 17:55:05
 **/
public class P852_PeakIndexInAMountainArray {
    /**
     * 。。。
     *
     * @param A
     * @return
     */
    public int peakIndexInMountainArray(int[] A) {
        if (A.length < 3) {
            return 0;
        }
        int lIndex = 0;

        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                lIndex = i;
            } else {
                break;
            }
        }
        return lIndex;
    }
}
