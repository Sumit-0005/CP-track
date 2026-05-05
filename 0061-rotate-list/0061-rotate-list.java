/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0 ) return head;
        ListNode result = null;
        ListNode cur = head;
        ListNode prev = null;
        int size = 0;
        while(cur != null) {
            size++;
            cur = cur.next;
        }
        cur = head;
        k %= size;
        if(k == 0) {
            return head;
        }
        k = size - k;
        for(int i = 1; i <= k; i++) {
            prev = cur;
            cur = cur.next;
        }

        if(prev != null) {
            prev.next = null;
        }
        result = cur;
        while(cur != null && cur.next != null) {
            cur = cur.next;
        }
        if(cur != null) {
            cur.next = head;
        }
        return result;
    }
}