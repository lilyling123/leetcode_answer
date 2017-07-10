package th83;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head;

        ListNode next = cur.next;
        while (next != null) {
            if (next.val != cur.val) {
                cur.next = next;
                next = next.next;
                cur = cur.next;
            } else {
                if (next.next == null) {
                    cur.next = null;
                }
                next = next.next;
            }

        }

        return head;
    }
}