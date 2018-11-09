package lw.learn.offer.util;


/**
 * @Author lw
 * @Date 2018-09-16 21:17:52
 **/
public  class ListNode {
    public int val;
    public ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }

    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        ListNode root = new ListNode(arr[0]);
        ListNode cur = root;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return root;
    }

    public static void printList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
    }
}

