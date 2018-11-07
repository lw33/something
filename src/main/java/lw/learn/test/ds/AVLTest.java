package lw.learn.test.ds;

import lw.learn.ds.AVLMap;
import lw.learn.ds.AVLSet;
import lw.learn.ds.AVLTree;
import lw.learn.ds.BST;
import lw.learn.utils.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author lw
 * @Date 2018-11-06 22:45:02
 **/
public class AVLTest {

    @Test
    public void test() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            Collections.sort(words1);
            AVLTree<String, Integer> avl = new AVLTree<>();
            long start = System.currentTimeMillis();
            for (String s : words1) {
                avl.add(s, null);
            }
            for (String s : words1) {
                avl.contains(s);
            }
            long end = System.currentTimeMillis();
            System.out.println("is BST: " + avl.isBST());
            System.out.println("is Balanced: " + avl.isBalanced());
            System.out.println("avl duration: " + (end - start));

            BST<String> bst = new BST<>();
            start = System.currentTimeMillis();
            for (String s : words1) {
                bst.add(s);
            }
            for (String s : words1) {
                bst.contains(s);
            }
            end = System.currentTimeMillis();
            System.out.println();
            System.out.println("bst duration: " + (end -start));
        }
    }

    @Test
    public void test2() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            AVLTree<String, Integer> avl = new AVLTree<>();
            long start = System.currentTimeMillis();
            for (String s : words1) {
                avl.add(s, null);
            }
            for (String s : words1) {
                avl.remove(s);
                if (!avl.isBalanced()) {
                    throw new RuntimeException("is not balanced...");
                }
            }
            long end = System.currentTimeMillis();/*
            System.out.println("is BST: " + avl.isBST());
            System.out.println("is Balanced: " + avl.isBalanced());*/
            System.out.println("avl duration: " + (end - start));

            BST<String> bst = new BST<>();
            start = System.currentTimeMillis();
            for (String s : words1) {
                bst.add(s);
            }
            for (String s : words1) {
                bst.remove(s);
            }
            end = System.currentTimeMillis();
            System.out.println();
            System.out.println("bst duration: " + (end - start));
        }
    }

    @Test
    public void test3() {
        ArrayList<String> words1 = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words1)) {
            AVLSet<String> avlSet = new AVLSet<>();
            words1.forEach(e -> avlSet.add(e));
            System.out.println(avlSet.size());

            AVLMap<String, Integer> avlMap = new AVLMap<>();
            words1.forEach(e -> {
                if (avlMap.contains(e)) {
                    avlMap.set(e, avlMap.get(e) + 1);
                } else {
                    avlMap.add(e, 1);
                }
            });
            System.out.println(avlMap.size());
            System.out.println(avlMap.get("pride"));
        }
    }
}
