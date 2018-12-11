package lw.learn.lc.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-15 13:10:43
 **/
public class P401_ReadBinaryWatch {

    public List<String> readBinaryWatch(int num) {

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {

                if (bitCount(i) + bitCount(j) == num) {
                    res.add(i + ":" + (j < 10 ? 0 + "" + j : j));
                }
            }
        }

        return res;

    }

    private int bitCount(int num) {
        String s = Integer.toBinaryString(num);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }


}
