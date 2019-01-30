package lw.learn.lc.string;

/**
 * @Author lw
 * @Date 2019-01-30 22:04:07
 **/
public class P6_ZigZagConversion {

    public String convert(String s, int numRows) {
        if (numRows <= 1 || numRows >= s.length()) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int mul = (numRows - 1) * 2;
        for (int i = 0; i < numRows; i++) {
            int m = 2 * i, j = i;
            while (j < s.length()) {
                res.append(s.charAt(j));
                m = mul - m;
                if (m == 0) m = mul;
                j += m;
            }
        }
        return res.toString();
    }
}
