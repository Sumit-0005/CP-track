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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode head= l;
        int c=0; 
        while( l1 != null && l2 != null){
            l.val = (l1.val + l2.val +c)%10;
            c = (l1.val + l2.val + c)/10;
            if(l1.next != null || l2.next != null){
                l.next = new ListNode();
                l= l.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            l.val = (l1.val +c)%10;
            c = (l1.val +c)/10;
            if(l1.next != null){
                l.next = new ListNode();
                l= l.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            l.val = (l2.val + c)%10;
            c = (l2.val +c)/10;
            if(l2.next != null){
                l.next = new ListNode();
                l = l.next;
            }
            l2 = l2.next;
        }
        if(c != 0){
            l.next = new ListNode();
            l = l.next;
            l.val = c;
        }
        return head;
    }
}