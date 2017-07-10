package th24;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = fakeHead.next;

        while (cur != null ) {
            pre.next = reverseTwoNode(cur);

            pre = cur;
            cur = pre.next;
        }

        return fakeHead.next;
    }

    private ListNode reverseTwoNode(ListNode node) {
        ListNode t = node.next;
        if (t != null) {
            node.next = t.next;
            t.next = node;

            return t;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);

        node = new Solution().swapPairs(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }
}