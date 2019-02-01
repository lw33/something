package lw.learn.lc.stack;


import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-05 17:41:12
 **/
public class P394_DecodeString {

    public String decodeString(String s) {

        char[] chars = s.toCharArray();
        LinkedList<Integer> times = new LinkedList<>();
        LinkedList<Character> alpha = new LinkedList<>();
        LinkedList<Character> popStack = new LinkedList<>();
        int pre = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '[') {
                times.addFirst(pre);
                alpha.addFirst(chars[i]);
                pre = 0;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                pre = pre * 10 + chars[i] - '0';
            } else if (chars[i] == ']') {
                boolean pushBack = false;
                while (!alpha.isEmpty()) {
                    if (alpha.getFirst() == '[') {
                        alpha.removeFirst();
                        break;
                    }
                    popStack.addFirst(alpha.removeFirst());
                }

                pushBack = !alpha.isEmpty();

            } else {
                alpha.addFirst(chars[i]);
            }
        }
        return "";
    }
}
