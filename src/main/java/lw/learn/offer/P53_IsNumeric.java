package lw.learn.offer;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author lw
 * @Date 2018-10-03 18:25:06
 *
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 **/
public class P53_IsNumeric {



    @Test
    public void test1() {
        char[] chars = {'1', '0', '0'};
        System.out.println(isNum(chars));

    }
    public boolean isNum(char[] str) {
        String regx = "[+|\\-]?\\d+(\\.\\d+)?(e[+|\\-]?\\d+)?";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
        }
        return sb.toString().matches(regx);
    }

    public boolean isNumeric(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        int symbolCount = 0;
        int exponentSymbolCount = 0;
        int exponentIndex = 0;
        int dotCount = 0;

        if (str[0] == '+' || str[0] == '-')
            symbolCount++;

        for (int i = symbolCount; i < str.length; i++) {
            if ((str[i] < '0' || str[i] > '9') && str[i] != 'e' && str[i] != 'E' && str[i] != '.') {
                return false;
            } else if (str[i] == '.') {
                dotCount++;
            } else if (str[i] == 'e' || str[i] == 'E') {
                exponentIndex = i;
                break;
            }
        }
        if (exponentIndex == 0 && dotCount <= 1) {
            return true;
        }
        if (exponentIndex == str.length - 1 || exponentIndex == symbolCount) {
            return false;
        }

        if (str[exponentIndex + 1] == '+' || str[exponentIndex + 1] == '-') {
            exponentSymbolCount++;
        }
        for (int i = exponentIndex + exponentSymbolCount + 1; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() {
        System.out.println(this.isNumeric(new char[]{'-', 'e', '0'}));
    }
}
