package lw.learn.lc.easy;

import lw.learn.ds.SegmentTree;

/**
 * @Author lw
 * @Date 2018-11-06 15:09:01
 **/
public class NumArray_303 {


    private SegmentTree<Integer> segmentTree;


    public NumArray_303(int[] nums) {

        Integer[] data = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }


}
