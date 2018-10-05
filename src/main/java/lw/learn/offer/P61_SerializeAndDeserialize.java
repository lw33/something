package lw.learn.offer;

import lw.learn.offer.util.TreeNode;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2018-10-03 22:25:02
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 **/
public class P61_SerializeAndDeserialize {

    String Serialize(TreeNode root) {


        return preOrder(root);
    }


    TreeNode Deserialize(String str) {
        String[] s = str.split("_");
        int[] index = new int[1];
        return dePreOrder(s, index);
    }

    public TreeNode dePreOrder(String[] s, int[] index) {
        if (index[0] == s.length) {
            return null;
        }
        if ("#".equals(s[index[0]])) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(s[index[0]]));
        index[0]++;
        node.left  = dePreOrder(s, index);
        index[0]++;
        node.right = dePreOrder(s, index);
        return node;
    }

    public String preOrder(TreeNode node) {
        if (node == null) {
            return "#_";
        }
        String res = String.valueOf(node.val) + "_";
        return res + preOrder(node.left) + preOrder(node.right);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(preOrder(root));
        String s = preOrder(root);
        System.out.println(Deserialize(s));
        System.out.println(preOrder(Deserialize(s)));

    }
}
