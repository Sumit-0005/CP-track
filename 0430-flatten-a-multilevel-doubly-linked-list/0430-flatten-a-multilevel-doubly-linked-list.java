/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return head;
        Stack<Node> stk = new Stack<>();
        Node node = head;
        while(node.child != null || node.next != null){
            if(node.child != null){
                if(node.next != null) stk.push(node.next);
                node.next = node.child;
                node.next.prev = node;
                node.child = null;
                continue;
            }
            node = node.next;
        }
        while(!stk.isEmpty()){
            Node pop = stk.pop();
            pop.prev = node;
            node.next = pop;
            while(node.next != null)
                node = node.next;
        }
        return head;
    }
}