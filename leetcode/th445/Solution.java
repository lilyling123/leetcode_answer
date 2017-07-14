package th445;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode zL1 = new ListNode(0);
        ListNode zL2 = new ListNode(0);
        ListNode res = new ListNode(0);
        //构建反转链表
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                ListNode cur = zL1.next;
                ListNode next = l1.next;
                zL1.next = l1;
                zL1.next.next = cur;
                l1 = next;
            }
            if (l2 != null) {
                ListNode cur = zL2.next;
                ListNode next = l2.next;
                zL2.next = l2;
                zL2.next.next = cur;
                l2 = next;
            }
        }
        int sum = 0;
        zL1 = zL1.next;
        zL2 = zL2.next;
        while (zL1 != null || zL2 != null) {
            if (zL1 != null) {
                sum += zL1.val;
                zL1 = zL1.next;
            }
            if (zL2 != null) {
                sum += zL2.val;
                zL2 = zL2.next;
            }
            res.val = sum % 10;
            sum /= 10;
            ListNode head = new ListNode(sum);
            head.next = res;
            res = head;
        }
        return res.val == 0 ? res.next : res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode next = head.next;
        head.next = new ListNode(1);
        System.out.println(next);
    }
}