package th86;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode cur = head;
        ListNode pre = fakeHead;
        //找到第一个大于等于x的元素,每次后面的元素如果小于x则插入到pre和cur之间
        while (cur.val < x) {
            pre = cur;
            cur = cur.next;
            if (cur == null)
                return head;
        }
        ListNode next = cur.next;
        ListNode preNext = cur;

        while (next != null) {
            if (next.val >= x) {
                preNext = next;
                next = next.next;
            } else {
                ListNode t = next.next;
                pre.next = next;
                next.next = cur;
                pre = pre.next;
                preNext.next = t;
                next = preNext.next;
            }
        }
        return null;
    }
}