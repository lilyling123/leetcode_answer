package th61;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode fakeHead = new ListNode(0);

        fakeHead.next = head;

        ListNode post = fakeHead;
        ListNode next = fakeHead;
        int n = 0;
        while (next.next != null) {
            next = next.next;
            n++;
        }
        int count = n - k % n;
        while (count-- > 0) {
            post = post.next;
        }
        next.next = head;
        fakeHead.next = post.next;
        post.next = null;

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);

        node = new Solution().rotateRight(node, 7);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}