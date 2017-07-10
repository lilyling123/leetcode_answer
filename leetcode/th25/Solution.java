package th25;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        ListNode cur = pre.next;

        while (cur != null) {
            pre.next = reverseKNode(pre.next, k);

            if (pre.next == cur)
                break;
            pre = cur;
            cur = cur.next;
        }

        return fakeHead.next;
    }

    private ListNode reverseKNode(ListNode node, int k) {
        ListNode top = new ListNode(0);
        top.next = node;
        ListNode pre = top;
        ListNode cur = pre.next;
        ListNode next = cur;
        int N = k;
        while (N-- > 0) {
            if (next == null) {
                return node;
            }
            next = next.next;
        }
        while (--k > 0 && cur != null && cur.next != null) {
            next = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = next;


        }

        if (k != 0) {
            return node;
        }
        return top.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node = new Solution().reverseKGroup(node, 4);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }


    }
}