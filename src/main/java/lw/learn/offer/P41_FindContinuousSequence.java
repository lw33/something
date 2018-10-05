package lw.learn.offer;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-10-03 10:42:09
 * <p>
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 **/
public class P41_FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (sum < 2) {
            return res;
        }

        int left = 1;
        int right = 1;
        int subSum = 1;

        while (right > left || right == 1) {
            if (subSum == sum) {
                ArrayList<Integer> subNums = new ArrayList<>();
                for (int j = left; j <= right; j++) {
                    subNums.add(j);
                }
                res.add(subNums);
                subSum -= left;
                left++;
            } else if (subSum < sum) {
                right++;
                subSum += right;
            } else {
                subSum -= left;
                left++;
            }
        }
        return res;
    }

    @Test
    public void test() {
        int[] arr = {1, 2};
        System.out.println(this.FindContinuousSequence(9));
    }
}
