package lw.learn.lc.string;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-07 23:22:05
 **/
public class P65_ValidNumber {

    /**
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * " -90e3   " => true
     * " 1e" => false
     * "e3" => false
     * " 6e-1" => true
     * " 99e2.5 " => false
     * "53.5e93" => true
     * " --6 " => false
     * "-+3" => false
     * "95a54e53" => false
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {

        if (s.length() == 0) {

            return false;
        }


        char[] str = s.toCharArray();
        boolean symbol = false;
        boolean dot = false;
        boolean startNum = false;
        boolean esymbol = false;
        int start = 0;
        int end = str.length - 1;

        while (start <= end && str[start] == ' ') {
            ++start;
        }

        if (start > end || str[start] == 'e') {
            return false;
        }

        while (end >= 0 && str[end] == ' ') {
            --end;
        }

        if (end < 0 || str[end] == 'e' || isSymbol(str[end]) || (start == end && !isNum(str[start]))) {
            return false;
        }

        for (; start <= end; start++) {
            if (str[start] == 'e') {
                start++;
                break;
            } else if (str[start] != ' ') {
                if (isNum(str[start])) {
                    startNum = true;
                } else if (isSymbol(str[start])) {
                    if (symbol || startNum || dot) {
                        return false;
                    }
                    symbol = true;
                } else if (str[start] == '.') {
                    if (dot) {
                        return false;
                    }
                    dot = true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (!startNum) {
            return false;
        }
        startNum = false;
        for (; start <= end; start++) {
            if (str[start] != ' ') {
                if (isNum(str[start])) {
                    startNum = true;
                } else if (isSymbol(str[start])) {
                    if (esymbol || startNum) {
                        return false;
                    }
                    esymbol = true;
                } else {
                    return false;
                }
            }else {
                return false;
            }
        }

        return true;
    }

    private boolean isNum(char num) {
        return num <= '9' && num >= '0';
    }

    private boolean isSymbol(char s) {
        return s == '+' || s == '-';
    }

    @Test
    public void test() {
        System.out.println(this.isNumber("46.e3"));
    }
}
