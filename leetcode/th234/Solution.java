package th234;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null)
            return true;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p1 = fakeHead;
        ListNode p2 = fakeHead;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = reverserListNode(p1.next);
        p1.next = null;

        while (head != null && p2 != null) {
            if (head.val != p2.val) {
                return false;
            }
            head = head.next;
            p2 = p2.next;
        }
        return true;
    }

    private ListNode reverserListNode(ListNode node) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = node;
        ListNode next = node.next;
        while (next != null) {
            ListNode t = fakeHead.next;
            fakeHead.next = next;
            node.next = next.next;
            next.next = t;

            next = node.next;
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(1);

        boolean flag = new Solution().isPalindrome(node);

        System.out.println(flag);
    }


}