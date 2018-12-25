package lw.learn.lc.medium;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-24 17:00:57
 **/
public class P406_QueueReconstructionByHeight {

    //[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    //[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    public int[][] reconstructQueue(int[][] people) {

        sort(people);

        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            if (index != i) {
                int[] tmp = people[i];
                int j = i;
                for (; j > index; j--) {
                    people[j] = people[j - 1];
                }
                people[j] = tmp;
            }
        }
        return people;
    }

    public int[][] reconstructQueue1(int[][] people) {
        sort(people);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(people);
    }

    private void sort(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
    }


    @Test
    public void test() {
        int[][] ints = JSON2Java.json2int2Array("[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]");
        int[][] ints1 = this.reconstructQueue(ints);
        System.out.println(Arrays.deepToString(ints1));
    }

    public int java() {
        while (true) {
            System.out.println("java");
        }
    }
}
