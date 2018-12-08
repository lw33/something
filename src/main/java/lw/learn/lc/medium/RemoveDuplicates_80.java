package lw.learn.lc.medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-12-06 22:51:02
 **/
public class RemoveDuplicates_80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 1;
        int pre;
        int next;
        int i = 1;
        pre = nums[0];
        int length = nums.length - 1;
        for (; i < length; i++) {
            next = nums[i + 1];
            if (nums[i] != pre || nums[i] != next) {
                nums[index++] = nums[i];
            }
            pre = nums[i];
        }
        nums[index++] = nums[i];
        return index;
    }
    @Test
    public void test() {
        int[] arr = {1, 1, 1, 2, 2, 2};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
        /*ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, arr);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            list.remove(1);
        }*/
    }
}
