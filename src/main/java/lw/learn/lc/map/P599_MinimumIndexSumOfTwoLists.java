package lw.learn.lc.map;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-02-11 21:22:11
 **/
public class P599_MinimumIndexSumOfTwoLists {

    /**
     * 使用 map 存入短的字符数组 与它的索引
     * 然后查并且比较
     *
     * @param list1
     * @param list2
     * @return
     */
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            String[] tmp = list1;
            list1 = list2;
            list2 = tmp;
        }
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new LinkedList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null) {
                int sum = index + i;
                if (min >= sum) {
                    res.add(list2[i]);
                    min = sum;
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
