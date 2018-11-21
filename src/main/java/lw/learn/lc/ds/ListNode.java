package lw.learn.lc.ds;

/**
 * @Author lw
 * @Date 2018-11-13 22:05:16
 **/
public class ListNode {
    public int val;
    public ListNode next;


    public ListNode() {

    }

    public ListNode(int x) {
        this(x, null);
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode root;
        root = new ListNode(arr[0]);
        ListNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return root;
    }
    public static ListNode[] buildListArr(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode[] res = new ListNode[arr.length];
        ListNode root;
        root = new ListNode(arr[0]);
        ListNode cur = root;
        res[0] = cur;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
            res[i] = cur;
        }
        return res;
    }
    public static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}
