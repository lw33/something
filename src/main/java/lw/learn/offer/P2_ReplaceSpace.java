package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 15:38:10
 *
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 **/
public class P2_ReplaceSpace {

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.length() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i) == ' ' ? "%20" : str.charAt(i));
        }
        return sb.toString();
    }
}
