class Solution {
    public int minLength(String s) {
        Stack<Character> stk = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char curr = s.charAt(i);
            if(stk.isEmpty()){
                stk.push(curr);
                continue;
            }
            if(curr == 'B' && stk.peek() == 'A')
                stk.pop();
            else if(curr == 'D' && stk.peek() == 'C')
                stk.pop();
            else
                stk.push(curr);
        }
        return stk.size();
    }
}