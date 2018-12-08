package lw.learn.lc.medium;

/**
 * @Author lw
 * @Date 2018-11-13 14:40:52
 **/
public class SortColors_75 {

    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors1(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; i++) {
            if (nums[i] == 0) {
                swap(nums, ++zero, i++);
            } else if (nums[i] == 2) {
                swap(nums, --two, i);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
