package lw.learn.lc.math;

/**
 * @Author lw
 * @Date 2019-03-07 23:16:39
 **/
public class P223_RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rec1 = (D - B) * (C - A);
        int rec2 = (H - F) * (G - E);
        int res = rec1 + rec2;

        if (B >= H || F >= D || E >= C || A >= G) {
            return res;
        }

        int bx = Math.max(A, E);
        int by = Math.max(B, F);

        int tx = Math.min(C, G);
        int ty = Math.min(D, H);

        return res - (tx - bx) * (ty - by);
    }
}
