package lw.learn.lc.medium;

import lw.learn.lc.ds.ListNode;
import org.junit.Test;

import java.util.HashSet;

/**
 * @Author lw
 * @Date 2018-12-29 16:46:39
 **/
public class P817_LinkedListComponents {

    /**
     * 1，由于数组G是链表head所有元素值的子集，所以数组G中的任何元素都能在链表中找到（这TM不是废话？）;
     * 2，因此G中的每个元素就可以看做是链表head的一个子链表，即G中的每个元素都是链表head的组件；
     * 3，但是此时的组件还不敢称之为真正的组件，因为完全存在这样一种可能：
     *    3.1 G中任意组合的两个元素a, b构成了一个更长的head的子链表 a->b ，
     *    3.2 此时根据题意 a->b 比 a 和 b 都要长，所以 a->b 包涵了 a、b 成为真正的组件，原来的a、b 就不能算组件了，
     *    3.3 如此一来问题变成了 对于给定的集合G，G中所有的元素能构成多少个head中相连的子链表？
     * @param head
     * @param G
     * @return
     */
    public int numComponents(ListNode head, int[] G) {

        if (G.length == 0 || head == null) {
            return 0;
        }

        // 将 G 中的数加入 set
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < G.length; i++) {
            set.add(G[i]);
        }

        // 组件总数
        int count = 0;
        // 游标
        ListNode cur = head;
        // 立一个 flag ， 当 flag 为 true 时，表示前一个数不存在
        boolean flag = true;
        while (cur != null) {
            // 当当前节点不存在 G 中时 修改flag
            if (!set.contains(cur.val)) {
                flag = true;
            } else {
                // 上一个节点不在 G 中时 出现新的组件 并修改 flag
                if (flag) {
                    count++;
                    flag = false;
                }
            }
            cur = cur.next;
        }
        return count;
    }

    @Test
    public void test() {
        int[] arr = {0, 1, 2};
        int[] g = {2};
        ListNode root = ListNode.buildList(arr);
        System.out.println(this.numComponents(root, g));
    }
}
