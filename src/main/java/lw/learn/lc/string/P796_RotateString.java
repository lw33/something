package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-01-21 23:23:32
 **/
public class P796_RotateString {
    public boolean rotateString(String A, String B) {

        return A.equals(B) || (B + B).indexOf(A) > 0;
    }
}
