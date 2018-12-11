package lw.learn.lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-03 13:27:39
 **/
public class P119_PascalsTriangleII {

    static List<List<Integer>> pascalsTriangle = new ArrayList<>();
    static {
        pascalsTriangle.add(Arrays.asList(1));
        for (int i = 1; i < 34; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            List<Integer> preList = pascalsTriangle.get(i - 1);
            for (int j = 1; j < preList.size(); j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
            pascalsTriangle.add(list);
        }
    }

    public List<Integer> getRow(int rowIndex) {
        //return pascalsTriangle.get(rowIndex);
        Integer[] result = new Integer[rowIndex + 1];
        Arrays.fill(result, 0);
        result[0] = 1;
        for (int i = 1; i < result.length; i ++) {
            for (int j = i; j > 0; j --) {
                result[j] = result[j] + result[j - 1];
            }
        }
        return Arrays.asList(result);
    }
}
