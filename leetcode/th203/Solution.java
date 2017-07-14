package th203;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;


        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = pre.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}