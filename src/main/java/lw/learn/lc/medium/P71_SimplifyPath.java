package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Stack;

/**
 * @Author lw
 * @Date 2018-12-14 01:19:39
 **/
public class P71_SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] split = path.split("/");

        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (split[i].length() != 0 && split[i].equals(".")) {
                    stack.push(split[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        if (stack.isEmpty()) {
            return sb.toString();
        }
        while (!stack.isEmpty()) {
            sb.insert(1, stack.pop() + "/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Test
    public void test() {
        String path = "///";
        System.out.println(this.simplifyPath(path));
    }
}
