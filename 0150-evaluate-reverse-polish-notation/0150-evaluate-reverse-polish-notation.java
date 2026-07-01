class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c: tokens){
            if(c.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if(c.equals("-")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second - first);
            }else if(c.equals("*"))
                stack.push(stack.pop()*stack.pop());
            else if(c.equals("/")){
                int first = stack.pop();
                int second = stack.pop();
                stack.push(second/first);
            }else
                stack.push(Integer.parseInt(c));
        }
        return stack.peek();
    }
}