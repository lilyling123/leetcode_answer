package th141;

import Utils.ListNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode walker = head;
        ListNode runner = head;

        while (runner != null && runner.next != null) {
            runner = runner.next.next;
            walker = walker.next;

            if (runner == walker)
                return true;
        }

        return false;
    }
}