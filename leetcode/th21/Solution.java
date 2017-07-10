package th21;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
        ListNode pre = fakeHead;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            } else if (l2 == null) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                if (l1.val < l2.val) {
                    pre.next = l1;
                    pre = pre.next;
                    l1 = l1.next;
                } else {
                    pre.next = l2;
                    pre = pre.next;
                    l2 = l2.next;
                }
            }
        }

        return fakeHead.next;
    }
}