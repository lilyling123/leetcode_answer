package th237;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public void deleteNode(ListNode node) {
        if (node != null && node.next != null) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}