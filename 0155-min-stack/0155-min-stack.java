class MinStack {
    Deque<Integer> st;
    Deque<Integer> minStack; 
    public MinStack() {
        st = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        st.add(val);
        if(minStack.isEmpty() || minStack.peekLast()>=val){
            minStack.add(val);
        }
    }
    
    public void pop() {
        int popped = st.pollLast();
        if(popped == minStack.peekLast()) minStack.pollLast();
    }
    
    public int top() {
        return st.peekLast();
    }
    
    public int getMin() {
        return minStack.peekLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */