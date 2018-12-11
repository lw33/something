package lw.learn.lc.medium;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-15 10:33:00
 **/
public class P46_Permute {

    public List<List<Integer>> permute1(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        List<Integer> p = new ArrayList<>();
        permutation1(numList, p, res);
        return res;
    }

    // p 中存在index个元素
    private void permutation1(ArrayList<Integer> numList, List<Integer> p, List<List<Integer>> res) {
        if (numList.size() == 0) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            Integer integer = numList.remove(i);
            p.add(integer);
            permutation1(numList, p, res);
            numList.add(i,integer);
            p.remove(p.size() - 1);
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        List<Integer> p = new ArrayList<>();
        permutation(nums, 0, p, used, res);
        return res;
    }

    // p 中存在index个元素
    private void permutation(int[] nums, int index, List<Integer> p, boolean[] used, List<List<Integer>> res) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                p.add(nums[i]);
                permutation(nums, index + 1, p, used, res);
                used[i] = false;
                p.remove(p.size() - 1);
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {1, 2, 3};
        System.out.println(this.permute1(arr));
        /*LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()) {
            Integer next = integerListIterator.next();
            integerListIterator.remove();
            System.out.println(list);
            integerListIterator.add(next);
        }
        System.out.println(list);*/
    }
}
