package th92;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode mNode = fakeHead;

        ListNode nNode = head;

        for (int i = 0; i < m - 1 && mNode.next != null; i++) {
            mNode = mNode.next;
        }

        ListNode start = mNode.next;
        if (start == null)
            return head;

        ListNode next = start.next;

        for (int i = 0; i < n - m && next != null; i++) {
            start.next = next.next;
            next.next = mNode.next;
            mNode.next = next;
            next = start.next;
        }

        return fakeHead.next;
    }
}