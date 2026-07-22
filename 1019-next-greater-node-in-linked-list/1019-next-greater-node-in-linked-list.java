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
    public int[] nextLargerNodes(ListNode head) {
        ArrayDeque<Integer> stk = new ArrayDeque<>();
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tail = head;
        while(tail != null){
            list.add(tail.val);
            tail = tail.next;
        }
        int res[] = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            while(!stk.isEmpty() && list.get(stk.peek()) < list.get(i)) res[stk.pop()] = list.get(i);
            stk.push(i);
        }
        return res;
    }
}