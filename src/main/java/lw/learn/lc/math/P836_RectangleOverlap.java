package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-02-15 09:53:17
 **/
public class P836_RectangleOverlap {
    /**
     * @param rec1
     * @param rec2
     * @return
     */
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // 被压的矩形右上角
        int olbX = Integer.max(rec1[0], rec2[0]);
        // 上面的矩形左下角
        int oltX = Integer.min(rec1[2], rec2[2]);
        int olbY = Integer.max(rec1[1], rec2[1]);
        int oltY = Integer.min(rec1[3], rec2[3]);

        return (olbX > oltX) && (olbY > oltY);
    }
}
