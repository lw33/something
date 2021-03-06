package lw.learn.test.ds;

import lw.learn.ds.BSTSet;
import lw.learn.ds.LinkedListSet;
import lw.learn.ds.Trie;
import lw.learn.utils.FileOperation;

import java.util.ArrayList;

/**
 * @Author lw
 * @Date 2018-11-05 15:28:06
 **/
public class SetTest {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");
        long start = 0;
        long end = 0;
        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            start = System.currentTimeMillis();
            for (String word : words1)
                set1.add(word);
            end = System.currentTimeMillis();
            System.out.println("BSTSet add: " + (end -start));
            start = System.currentTimeMillis();
            for (String word : words1)
                set1.contains(word);
            end = System.currentTimeMillis();
            System.out.println("BSTSet contains: " + (end -start));
            LinkedListSet<String> set11 = new LinkedListSet<>();
            start = System.currentTimeMillis();
            for (String s : words1) {
                set11.add(s);
            }
            end = System.currentTimeMillis();
            System.out.println("LinkedListSet add: " + (end-start));

            start = System.currentTimeMillis();
            for (String s : words1) {
                set1.contains(s);
            }
            end = System.currentTimeMillis();
            System.out.println("LinkedListSet contains: " + (end - start));
            Trie trie = new Trie();
            start = System.currentTimeMillis();
            for (String s : words1) {
                trie.add(s);
            }
            end = System.currentTimeMillis();
            System.out.println("Trie add: " + (end-start));

            start = System.currentTimeMillis();
            for (String s : words1) {
                trie.contains(s);
            }
            end = System.currentTimeMillis();
            System.out.println("Trie contains: " + (end - start));
            System.out.println("BSTSet Total different words: " + set1.size());
            System.out.println("LinkedListSet Total different words: " + set11.size());
            System.out.println("Trie Total different words: " + trie.size());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if (FileOperation.readFile("a-tale-of-two-cities.txt", words2)) {
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for (String word : words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.size());
        }
    }
}
