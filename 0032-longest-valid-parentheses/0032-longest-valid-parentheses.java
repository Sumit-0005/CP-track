class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stk = new Stack<>();
        stk.push(-1);
        int max_len = 0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i) == '(')
                stk.push(i);
            else{
                stk.pop();
                if(stk.isEmpty())
                    stk.push(i);
                else
                    max_len = Math.max(max_len, i-stk.peek());
            }
        return max_len;
    }
}