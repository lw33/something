package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-11 22:09:41
 **/
public class P717_1BitAnd2BitCharacters {

    /**
     * 最后一个0 前面必须要有偶数个 1
     *
     * @param bits
     * @return
     */
    public boolean isOneBitCharacter(int[] bits) {

        if (bits.length <= 1) {
            return true;
        }
        if (bits[bits.length - 2] == 0) {
            return true;
        }
        int one = 0;
        for (int i = bits.length - 2; i >= 0; i--) {
            if (bits[i] == 1) {
                one++;
            } else {
                break;
            }
        }
        return one % 2 == 0;
    }
}
