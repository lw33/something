package lw.learn.lc.easy;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-12-25 12:44:10
 **/
public class P744_FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {

        for (char letter : letters) {
            if (letter > target) {
                return letter;
            }
        }
        return letters[0];
    }

    public char nextGreatestLetter1(char[] letters, char target) {

        int start = 0;
        int end = letters.length;

        int mid = 0;
        while (end > start) {
            mid = start + ((end - start) >> 1);
            if (letters[mid] <= target) {
                start = ++mid;
            } else {
                end = mid;
            }
        }
        if (mid == letters.length) {
            return letters[0];
        } else {
            return letters[mid];
        }
    }

    @Test
    public void test() {
        char[] chars = {'c', 'f', 'j'};
        char target = 'c';
        System.out.println(this.nextGreatestLetter1(chars, target));
    }


}
