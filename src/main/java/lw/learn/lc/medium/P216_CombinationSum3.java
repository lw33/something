package lw.learn.lc.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-15 13:08:58
 **/
public class P216_CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        int start = 1;
        List<Integer> c = new ArrayList<>();

        combinationSum3(n, k, start, c, res);

        return res;
    }

    private void combinationSum3(int n, int k, int start, List<Integer> c, List<List<Integer>> res) {
        if (n == 0) {
            if (k == c.size()) {
                res.add(new ArrayList<>(c));
            }
            return;
        }

        if (n < 0) {
            return;
        }

        for (int i = start; i <= 10 - (k - c.size()); i++) {
            c.add(i);
            combinationSum3(n - i, k, i+1, c, res);
            c.remove(c.size() - 1);
        }
    }


}
