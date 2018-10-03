package lw.learn.offer;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-02 00:00:36
 * <p>
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 **/
public class P23_VerifySquenceOfBST {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }


        return verifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean verifySquenceOfBST(int[] sequence, int start, int end){
        if (end < start) {
            return true;
        }
        int root = sequence[end];
        int right = start;
        boolean flag = false;
        for (int i = end; i >= start; i--) {
            if (sequence[i] < root) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
                right = i;
            }
        }

        return verifySquenceOfBST(sequence, start, right - 1) && verifySquenceOfBST(sequence, right, end - 1);
    }
    
    @Test
    public void test() {
        int[] arr = {4, 8, 6, 12, 16, 14, 10};
        int[] arr2 = {7, 4, 6, 5};
        System.out.println(this.VerifySquenceOfBST(arr));
        System.out.println(this.VerifySquenceOfBST(arr2));
    }

}
