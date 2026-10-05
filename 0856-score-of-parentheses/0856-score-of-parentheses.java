class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') {
                stack.push(0);
            }
            else if (s.charAt(i) == ')') {
                int val = stack.pop();
                int ans = Math.max(2*val,1);
                stack.push(ans + stack.pop());
            }

        }
        return stack.pop();
    }
}