package lw.learn.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-03-01 00:18:01
 **/
public class P89_GrayCode {

    public List<Integer> grayCode(int n) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < (1 << n); i++)
            res.add(i ^ (i >> 1));

        return res;
    }
}
