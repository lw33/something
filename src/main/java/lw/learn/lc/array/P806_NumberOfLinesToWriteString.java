package lw.learn.lc.array;

/**
 * @Author lw
 * @Date 2019-02-14 22:32:08
 **/
public class P806_NumberOfLinesToWriteString {

    /**
     * row 记录当前行
     * cur 记录当前行最后一位
     * 如果 cur > 100 时 则换行 并且将 之前加的数 再加回来
     *
     * @param widths
     * @param S
     * @return
     */
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[]{0, 0};
        }
        char[] chars = S.toCharArray();
        int row = 1;
        int n = 100;
        int cur = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = widths[chars[i] - 'a'];
            cur += count;
            if (cur > n) {
                row++;
                cur = count;
            }
        }
        return new int[]{row, cur};
    }
}
