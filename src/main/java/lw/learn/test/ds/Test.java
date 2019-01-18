package lw.learn.test.ds;

import lw.learn.ds.DenseGraph;
import lw.learn.ds.SparseGraph;
import lw.learn.lc.ds.ListNode;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @Author lw
 * @Date 2018-11-05 22:20:16
 **/
public class Test {

    @org.junit.Test
    public void test() {

        int n = 20;
        int m = 100;
        SparseGraph sparseGraph = new SparseGraph(20, false);
        for (int i = 0; i < m; i++) {
            sparseGraph.addEdge(new Random().nextInt(20), new Random().nextInt(20));
        }
        long start = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            sparseGraph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }

        long end = System.currentTimeMillis();
        System.out.println("SparseGraph: " + (end - start));

        DenseGraph denseGraph = new DenseGraph(20, false);
        for (int i = 0; i < m; i++) {
            denseGraph.addEdge(new Random().nextInt(20), new Random().nextInt(20));
        }
        start = System.currentTimeMillis();


        for (int i = 0; i < n; i++) {
            System.out.print(i + ": ");
            denseGraph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }

        end = System.currentTimeMillis();
        System.out.println("DenseGraph: " + (end - start));


    }
    @org.junit.Test
    public void test2() {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode listNode = ListNode.buildList(arr);
        ListNode.printList(listNode);
        ListNode reverse = ListNode.reverse(listNode);
        ListNode.printList(reverse);
        ListNode reverse1 = ListNode.reverse(reverse);
        ListNode.printList(reverse1);
    }

    @org.junit.Test
    public void test3() {
        Integer i = new Integer(2);
        Map<Integer, Integer> map = new HashMap<>();
        map.put(i, 1);
        for (Integer integer : map.keySet()) {
            System.out.println(integer.equals(i));
            System.out.println(integer == i);
        }
        String str = new String("java");
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        stringIntegerMap.put(str, 1);
        for (String s : stringIntegerMap.keySet()) {
            System.out.println(s == str);
            System.out.println(s.equals(str));
        }
    }

    @org.junit.Test
    public void test4() {
        Integer i = 1;
        Integer j = 1;
        Integer i1 = 127;
        Integer j1 = 127;
        Integer i2 = 128;
        Integer j2 = 128;
        System.out.println(i == j);
        System.out.println(i1 == j1);
        System.out.println(i2 == j2);
    }

    @org.junit.Test
    public void test5() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        List<? extends Object> list = nums;
        Object o1 = list.get(0);
        List<?> list1 = nums;
        Object o = list1.get(0);
        List<?> generic = generic(nums);
        Object o2 = generic.get(0);
        List<Integer> generic1 = (List<Integer>) generic;
        generic1.add(1);
        System.out.println(generic1);
    }

    public List<?> generic(List list) {
        return list;
    }

    @org.junit.Test
    public void test6() throws IOException, ClassNotFoundException {
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources("lw/learn/ds");
        //lw.learn.test.ds.ACAutomation$Node
        this.getClass().getClassLoader().loadClass("lw.learn.ds.ACAutomation$Node");
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            File file = new File(url.getPath());
            for (File listFile : file.listFiles()) {
                System.out.println(listFile.getName());
                this.getClass().getClassLoader().loadClass("lw.learn.ds." + listFile.getName().substring(0, listFile.getName().lastIndexOf(".")));
            }
        }
    }

    public static void main(String[] args) {
        //System.out.println(StringUtils.isEmpty(""));
    }
}
