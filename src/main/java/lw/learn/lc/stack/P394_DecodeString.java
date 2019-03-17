package lw.learn.lc.stack;


import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-05 17:41:12
 **/
public class P394_DecodeString {

    int i = 0;

    public String decodeString(String s) {

        char[] chars = s.toCharArray();

        return decodeString(chars);
    }

    private String decodeString(char[] chars) {

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (; i < chars.length && chars[i] != ']'; i++) {
            if (chars[i] <= '9' && chars[i] >= '0') {
                count = count * 10 + chars[i] - '0';
            } else if (chars[i] == '[') {
                i++;
                String s = decodeString(chars);
                for (int j = 0; j < count; j++) {
                    sb.append(s);
                }
                count = 0;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String s = "3[a]2[bc]";
        System.out.println(this.decodeString(s));
    }
}
