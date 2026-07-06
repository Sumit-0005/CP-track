class CustomStack {
    int[] stk;
    int top = -1;

    public CustomStack(int maxSize) {
        this.stk = new int[maxSize];
    }
    
    public void push(int x) {
        if(top < this.stk.length-1){
            top++;
            this.stk[top] = x;
        }
    }
    
    public int pop() {
        if(top != -1)
            return this.stk[top--];
        return -1;
    }
    
    public void increment(int k, int val) {
        for(int i=0; i<Math.min(k, top+1); i++)
            this.stk[i] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */