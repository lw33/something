package lw.learn.test.ds;

import lw.learn.ds.BSTMap;
import lw.learn.ds.HashMap;
import lw.learn.ds.LinkedListMap;
import lw.learn.utils.FileOperation;
import org.junit.Test;

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
        if(FileOperation.readFile("a-tale-of-two-cities.txt", words1)) {
            System.out.println("Total words: " + words1.size());
          /*  start = System.currentTimeMillis();
            LinkedListMap<String, Integer> map1 = new LinkedListMap<>();
            for (String s : words1) {
                if (map1.contains(s)) {
                    map1.set(s, map1.get(s) + 1);
                } else {
                    map1.add(s, 1);
                }
            }
            end = System.currentTimeMillis();
            System.out.println("LinkedListMap: " + (end - start));
            //System.out.println(map1.size());
            System.out.println(map1.size());
            System.out.println(map1.get("pride"));*/

            start = System.currentTimeMillis();
            BSTMap<String, Integer> map2 = new BSTMap<>();
            for (String s : words1) {
                if (map2.contains(s)) {
                    map2.set(s, map2.get(s) + 1);
                } else {
                    map2.add(s, 1);
                }
            }

            for (String s : words1) {
                map2.get(s);
            }
            //System.out.println(map1.size());
            end = System.currentTimeMillis();
            System.out.println("BSTMap: " + (end - start));
            System.out.println(map2.size());
            System.out.println(map2.get("cities"));


            start = System.currentTimeMillis();
            HashMap<String, Integer> map3 = new HashMap<>();
            for (String s : words1) {
                if (map3.contains(s)) {
                    map3.set(s, map3.get(s) + 1);
                } else {
                    map3.add(s, 1);
                }
            }

            for (String s : words1) {
                map3.get(s);
            }
            end = System.currentTimeMillis();
            System.out.println("HashMap: " + (end - start));
            //System.out.println(map1.size());
            System.out.println(map3.size());
            System.out.println(map3.get("cities"));

        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());


        }
    }

    @Test
    public void test2() {
        //new HashMap<>().;
        System.out.println(HashMap.tableSizeFor(11));
    }

}
