package lw.learn.lc.medium;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author lw
 * @Date 2018-12-28 17:44:10
 **/
public class P442_FindAllDuplicatesInAnArray {


    public List<Integer> findDuplicates666(int[] nums) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    public List<Integer> findDuplicates(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Arrays.stream(nums).
                boxed().
                collect(Collectors.groupingBy(Integer::new))
                .forEach((k, v) -> {
                    if (v.size() == 2) {
                        res.add(k);
                    }
                });
        return res;
    }

    @Test
    public void test() {
        int[] ints = JSON2Java.json2intArray("[4,3,2,7,8,2,3,1]");
        this.findDuplicates(ints);
    }
}
