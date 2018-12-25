package lw.learn.utils;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-28 17:12:56
 **/
public class JSON2Java {

    public static int[] json2intArray(String str) {
        List<Integer> list = JSON.parseArray(str, int.class);
        return list2intArray(list);
    }

    public static int[][] json2int2Array(String str) {
        List<int[]> ints = JSON.parseArray(str, int[].class);
        int[][] arr = new int[ints.size()][ints.get(0).length];
        for (int i = 0; i < ints.size(); i++) {
            for (int j = 0; j < ints.get(0).length; j++) {
                arr[i][j] = ints.get(i)[j];
            }
        }
        return arr;
    }

    public static int[] list2intArray(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

}
