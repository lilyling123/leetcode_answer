package th19;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        ListNode fakeHead = new ListNode(0);

        fakeHead.next = head;

        ListNode cur = head;
        ListNode pre = fakeHead;
        int count = n;
        while (--count > 0) {
            cur = cur.next;
            if (cur == null) return head;
        }
        while (cur.next != null) {
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return fakeHead.next;
    }
}