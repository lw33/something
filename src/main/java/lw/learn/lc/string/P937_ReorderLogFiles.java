package lw.learn.lc.string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author lw
 * @Date 2019-02-15 11:36:21
 **/
public class P937_ReorderLogFiles {
    /**
     * 先将数字日志换到 数组后部分
     * 再对前部分的 字符日志进行排序
     *
     * @param logs
     * @return
     */
    public String[] reorderLogFiles(String[] logs) {

        int numIndex = logs.length - 1;

        for (int i = numIndex; i >= 0; i--) {
            if (isNums(logs[i])) {
                swap(logs, i, numIndex--);
            }
        }
        Arrays.sort(logs, 0, numIndex + 1, Comparator.comparing(s -> s.substring(s.indexOf(" "))));
        return logs;
    }

    private boolean isNums(String s) {
        boolean space = false;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (space) {
                return c >= '0' && c <= '9';
            } else if (c == ' ') {
                space = true;
            }
        }
        return false;
    }

    private void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}
