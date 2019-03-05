package lw.learn.lc.bit;

import lw.learn.utils.LCUtils;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-04 16:01:32
 **/
public class P393_UTF8Validation {

    public boolean validUtf8(int[] data) {
        int two = 0xC0;
        int three = 0xE0;
        int four = 0xF0;
        int top = 0x80;
        int five = 0xF8;
        for (int i = 0; i < data.length; i++) {
            if ((data[i] & five) == five) {
                return false;
            }
            if ((data[i] & four) == four) {
                for (int j = 1; j < 4; j++) {
                    if (i == data.length - 1 || (data[++i] & two) == two) {
                        return false;
                    } else if ((data[i] & top) != top) {
                        return false;
                    }
                }
            } else if ((data[i] & three) == three) {
                for (int j = 1; j < 3; j++) {
                    if (i == data.length - 1 || (data[++i] & two) == two) {
                        return false;
                    } else if ((data[i] & top) != top) {
                        return false;
                    }
                }
            } else if ((data[i] & two) == two) {
                if (i == data.length - 1 || (data[++i] & two) == two) {
                    return false;
                } else if ((data[i] & top) != top) {
                    return false;
                }
            } else if ((data[i] & top) == top) {
                return false;
            }
        }
        return true;
    }

    public boolean validUtf8II(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int head = headOne(data[i]);
            if (head < 0 || head == 1) {
                return false;
            } else {
                for (int j = 1; j < head; j++) {
                    if (i == data.length - 1 || headOne(data[++i]) != 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public int headOne(int num) {
        //int two = 0xC0;
        //int three = 0xE0;
        //int four = 0xF0;
        //int top = 0x80;
        //int five = 0xF8;
        if ((num & 0xF8) == 0xF0) return 4;
        if ((num & 0xF0) == 0xE0) return 3;
        if ((num & 0xE0) == 0xC0) return 2;
        if ((num & 0xC0) == 0x80) return 1;
        if ((num & 0x80) == 0x00) return 0;
        return -1;
    }

    @Test
    public void test() {
        int[] arr = LCUtils.stringToIntegerArray("[10]");
        System.out.println(this.validUtf8II(arr));
    }
}
