class Solution {
    public String makeGood(String s) {
       Stack<Character> stk = new Stack<>();
       for(char c : s.toCharArray())
            if(!stk.isEmpty() && Math.abs(c - stk.peek()) == 32)
                stk.pop();
            else
                stk.push(c);
        StringBuilder res = new StringBuilder();
        while(!stk.isEmpty())
            res.insert(0, stk.pop());
        return res.toString();
    }
}