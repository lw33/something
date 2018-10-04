package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-03 16:02:36
 *
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0。
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 *     1a33
 * 输出
 * 复制
 * 2147483647
 *     0
 *
 **/
public class P49_String2Integer {

    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        boolean isNegarive = false;
        int num = 0;
        int i = 0;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            if (str.charAt(i) == '-') {
                isNegarive = true;
            }
            i = 1;
        }
        for (; i < str.length(); i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                num += (str.charAt(i) - '0') * Math.pow(10, str.length() - i - 1);
            } else {
                return 0;
            }
        }

        if (isNegarive) {
            if (num == Integer.MAX_VALUE) {
                if (str.charAt(str.length() - 1) - '0' == 8) {
                    num = ~num;
                }else {
                    num = -num;
                }
            } else {
                num = -num;
            }
        }

        return num;
    }
}
