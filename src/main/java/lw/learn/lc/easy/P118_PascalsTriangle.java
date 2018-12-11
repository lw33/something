package lw.learn.lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-03 13:27:39
 **/
public class P118_PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalsTriangle = new ArrayList<>();

        if (numRows == 0) {
            return pascalsTriangle;
        }
        pascalsTriangle.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = pascalsTriangle.get(i - 1);
            for (int j = 1; j < preList.size(); j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            pascalsTriangle.add(list);
        }
        return pascalsTriangle;
    }
}
