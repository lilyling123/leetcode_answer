package th23;

import Utils.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val > o2.val ? -1 : o1.val == o2.val ? 0 : 1;
            }
        });
        for (ListNode list : lists) {
            queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll == null) {
                continue;
            }
            cur.next = poll;
            cur = cur.next;
            if (poll.next != null) {
                queue.add(poll.next);
            }
        }
        return fakeHead.next;
    }

    public static void main(String[] args) {
        new Solution().mergeKLists(new ListNode[]{});
    }
}