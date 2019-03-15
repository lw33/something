package lw.learn.lc.string;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-15 11:23:54
 **/
public class P722_RemoveComments {

    /**
     * 步骤较为繁琐
     *
     * @param source
     * @return
     */
    public List<String> removeComments(String[] source) {

        // 结果
        List<String> res = new ArrayList<>();
        // 记录是否开启多行注释 true 为否
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for (String s : source) {
            char[] chars = s.toCharArray();
            int i = 0;
            for (; i < chars.length; i++) {
                if (chars[i] == '/') {
                    // 没有开启多行注释 有单行注释 直接跳出
                    if (flag && i < chars.length - 1 && chars[i + 1] == '/') {
                        break;
                    } else if (flag && i < chars.length - 1 && chars[i + 1] == '*') {
                        flag = false;
                        i++;
                    } else {
                        if (flag) {
                            sb.append(chars[i]);
                        }
                    }
                } else if (chars[i] == '*') {
                    // 已开启多行注释 消除
                    if (i < chars.length - 1 && !flag && chars[i + 1] == '/') {
                        flag = true;
                        i++;
                    } else {
                        if (flag) {
                            sb.append(chars[i]);
                        }
                    }
                } else {
                    if (flag) {
                        sb.append(chars[i]);
                    }
                }
            }
            // 没有多行注释 并且有内容
            if (flag && sb.length() > 0) {
                res.add(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return res;
    }

    @Test
    public void test() {
        String[] sources = {
                "void func(int k) {",
                "// this function does nothing /*",
                "   k = k*2/4;",
                "   k = k/2;*/",
                "}"
        };
        //String[] sources = {"a/*comment", "line", "more_comment*/b"};
        System.out.println(this.removeComments(sources));
    }
}
