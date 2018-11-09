package lw.learn.test.ds;

import lw.learn.ds.*;
import lw.learn.utils.FileOperation;
import lw.learn.utils.TimeHelper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @Author lw
 * @Date 2018-11-07 18:20:35
 **/
public class RBTest {

    @Test
    public void test1() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            RBSet<String> rbSet = new RBSet<>();
            words1.forEach(e -> rbSet.add(e));
            System.out.println(rbSet.size());

            RBMap<String, Integer> rbMap = new RBMap<>();
            words1.forEach(e -> {
                if (rbMap.contains(e)) {
                    rbMap.set(e, rbMap.get(e) + 1);
                } else {
                    rbMap.add(e, 1);
                }
            });
            System.out.println(rbMap.size());
            System.out.println(rbMap.get("pride"));
        }
    }

    @Test
    public void test2() {
        RBMap<Integer, Integer> rbMap = new RBMap<>();
        rbMap.add(1, 3);
        rbMap.add(2, 3);
        //rbMap.add(34, 2);
        System.out.println(rbMap);
    }

    @Test
    public void test3() {
        RBSet<Integer> rbSet = new RBSet<>();
        BSTSet<Integer> bstSet = new BSTSet<>();
        LinkedListSet<Integer> listSet = new LinkedListSet<>();
        int n = 9999;
        TimeHelper<Set<Integer>, Integer> timeHelper = new TimeHelper();
        System.out.println(timeHelper.duration(new Add(), rbSet, n));
        System.out.println(timeHelper.duration(new Add(), bstSet, n));
        System.out.println(timeHelper.duration(new Add(), listSet, n));

        HashMap<Add, Add> hashMap = new HashMap<>();
        hashMap.put(new Add(), new Add());
        hashMap.put(new Add(), new Add());
        hashMap.put(new Add(), new Add());
        hashMap.put(new Add(), new Add());
        hashMap.put(new Add(), new Add());

    }

    class Add implements BiConsumer<Set<Integer>, Integer> {

        @Override
        public void accept(Set<Integer> set, Integer n) {
            for (int i = 0; i < n; i++) {
                set.add(i);
            }
        }
    }
}
