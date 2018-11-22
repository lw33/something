package lw.learn.lc.hard;

import com.sun.org.apache.bcel.internal.generic.I2F;
import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author lw
 * @Date 2018-11-21 14:45:10
 **/
public class Codec_297 {
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null)
                return "$!";
            String res = root.val + "!";
            res += serialize(root.left);
            res += serialize(root.right);
            return res;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] split = data.split("!");
            Queue<String> queue = new LinkedList<>();
            for (int i = 0; i < split.length; i++) {
                queue.offer(split[i]);
            }
            return preOrder(queue);
        }

        private TreeNode preOrder(Queue<String> queue) {
            String value = queue.poll();
            if ("$".equals(value)) {
                return null;
            }
            TreeNode node = new TreeNode(Integer.valueOf(value));
            node.left = preOrder(queue);
            node.right = preOrder(queue);
            return node;
        }
    }
}
