package lw.learn.test.ds;

import lw.learn.ds.BSTMap;
import lw.learn.ds.LinkedListMap;
import lw.learn.utils.FileOperation;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-11-05 16:58:34
 **/
public class MapTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        long start = 0;
        long end = 0;
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());
            start = System.currentTimeMillis();
            LinkedListMap<String, Integer> map1 = new LinkedListMap<>();
            for (String s : words1) {
                if (map1.contains(s)) {
                    map1.set(s, map1.get(s) + 1);
                } else {
                    map1.add(s, 1);
                }
            }
            end = System.currentTimeMillis();
            System.out.println(end - start);
            //System.out.println(map1.size());
            System.out.println(map1.size());
            System.out.println(map1.get("pride"));

            start = System.currentTimeMillis();
            BSTMap<String, Integer> map2 = new BSTMap<>();
            for (String s : words1) {
                if (map2.contains(s)) {
                    map2.set(s, map2.get(s) + 1);
                } else {
                    map2.add(s, 1);
                }
            }
            //System.out.println(map1.size());
            end = System.currentTimeMillis();
            System.out.println(end - start);
            System.out.println(map2.size());
            System.out.println(map2.get("pride"));
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());


        }
    }
}
