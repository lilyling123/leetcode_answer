package th148;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {

        ListNode fakeHead = new ListNode(0), cur = fakeHead;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null)
            cur.next = l1;

        if (l2 != null)
            cur.next = l2;

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(7);
        node.next = new ListNode(6);
        node.next.next = new ListNode(5);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(3);
        node.next.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next.next = new ListNode(1);


        node = new Solution().sortList(node);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}