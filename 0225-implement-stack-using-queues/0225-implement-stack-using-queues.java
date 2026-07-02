class MyStack {

    private Queue queue;

    public void push(int x) {
        Queue q = new LinkedList();
        q.add(x);
        q.add(queue);
        queue = q;
    }

    public int pop() {
        int val = (int) queue.remove(); 
        queue = (Queue) queue.peek(); 
        return val;                     
    }

    public int top() {
        return (int) queue.peek();
    }

    public boolean empty() {
        return queue == null;
    }
}