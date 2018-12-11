package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-15 10:58:00
 **/
public class P77_Combine {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();


        List<Integer> c = new ArrayList<>();

        combination(n, 1, k, c, res);

        return res;
    }

    // index 表示元素下标
    private void combination(int n, int index, int k, List<Integer> c, List<List<Integer>> res) {
        if (c.size() == k) {
            res.add(new ArrayList<>(c));
            return;
        }

        //
        for (int i = index; i <= n - (k - c.size()) + 1; i++) {
            c.add(i);
            combination(n, i, k, c, res);
            c.remove(c.size() - 1);
        }
    }

    @Test
    public void test() {
        this.combine(4, 2);
    }
}
