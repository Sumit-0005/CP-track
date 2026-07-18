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
    private ListNode nextNode(ListNode node){
        int val = node.val;
        if(node.next == null || node.val != node.next.val)
            return node;
        while(node != null && node.val == val)
            node = node.next;
        return node;
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null) {
            ListNode next = nextNode(node.next);
            node.next = next;
            if (next == null || next.next == null) break;
            if (next.val != next.next.val) 
                node = node.next;
        }
        return dummy.next;
    }
}