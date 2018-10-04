package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-03 19:30:00
 *
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 **/
public class P54_FirstAppearingOnce {

    StringBuilder sb = new StringBuilder();
    int[] hash = new int[256];

    public void Insert(char ch) {
        sb.append(ch);
        hash[ch]++;
    }

    public char FirstAppearingOnce() {

        for (int i = 0; i < sb.toString().length(); i++) {
            if (hash[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }

        return '#';
    }
}
