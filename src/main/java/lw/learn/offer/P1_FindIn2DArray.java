package lw.learn.offer;

/**
 * @Author lw
 * @Date 2018-10-01 15:17:53
 *
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 **/
public class P1_FindIn2DArray {

    public boolean Find(int target, int[][] array) {
        if (array == null || array.length < 1 || array[0].length < 1) {
            return false;
        }
        int i = 0;
        int j = array[0].length - 1;
        while (j >= 0 && i < array.length) {
            if (array[i][j] < target) {
                i++;
            } else if (array[i][j] > target) {
                j--;
            } else {
                return true;
            }
        }
        return false;
    }
}
