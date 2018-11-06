package lw.learn.test.ds;

import lw.learn.ds.SegmentTree;

/**
 * @Author lw
 * @Date 2018-11-06 14:35:26
 **/
public class SegmentTreeTest {

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 2, 3, 4};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree.query(0, 4));
        System.out.println(segmentTree.query(1, 1));
        System.out.println(segmentTree.query(0, 1));
        System.out.println(true);
    }
}
