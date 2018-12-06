package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-06 20:12:51
 **/
public class BackspaceCompare_844 {

    public boolean backspaceCompare(String S, String T) {
        int cur1 = S.length() - 1;
        int cur2 = T.length() - 1;
        int del1 = 0;
        int del2 = 0;
        while (cur1 >= 0 && cur2 >= 0) {
            if (S.charAt(cur1) != '#') {
                if (del1 > 0) {
                    del1--;
                    cur1--;
                }
            } else {
                del1++;
                cur1--;
            }
            if (T.charAt(cur2) != '#') {
                if (del2 > 0) {
                    del2--;
                    cur2--;
                }
            } else {
                del2++;
                cur2--;
            }
            if (del2 == 0 && del1 == 0) {
                if (cur1 < 0 || cur2 < 0) {
                    break;
                }
                if (S.charAt(cur1) == '#' || T.charAt(cur2) == '#') {
                    continue;
                }
                if (S.charAt(cur1) != T.charAt(cur2)) {
                    return false;
                }
                cur1--;
                cur2--;
            }
        }
        while (cur1 >= 0) {
            if (S.charAt(cur1) != '#') {
                if (del1 == 0) {
                    return false;
                } else {
                    del1--;
                }
            } else {
                del1++;
            }
            cur1--;
        }
        while (cur2 >= 0) {
            if (T.charAt(cur2) != '#') {
                if (del2 == 0) {
                    return false;
                } else {
                    del2--;
                }
            } else {
                del2++;
            }
            cur2--;
        }
        return true;
    }

    //todo 666
    public boolean backspaceCompare666(String S, String T) {
        return sol(S).equals(sol(T));
    }

    public String sol(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            //如不是'#'，则加入到sb
            if (c != '#') {
                sb.append(c);
            }
            //否则是'#',并且sb不为空，则删除sb中最后一个元素（必须要判断sb不为空，如果为空，删除会出异常）
            else {
                if (sb.length() > 0) //关键之处
                    sb.deleteCharAt(sb.length() - 1);//deleteCharAt()函数
            }
        }
        return sb.toString();

    }
    @Test
    public void test() {
        //"isfcow#"
        //"isfcog#w#"
        String s = "isfcow#";
        String t = "isfcog#w#";
        System.out.println(this.backspaceCompare(s, t));
    }

}
