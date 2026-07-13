class Solution {
    public String smallestSubsequence(String s) {
        int[] cnt = new int[26];
        for(char c : s.toCharArray())
            cnt[c-'a']++;
        boolean[] visited = new boolean[26];
        Stack<Character> stk = new Stack<>();
        for(char c : s.toCharArray()){
            cnt[c-'a']--;
            if(visited[c-'a'])
                continue;
            while(!stk.isEmpty() && c<stk.peek() && cnt[stk.peek()-'a']>0)
                visited[stk.pop()-'a'] = false;
            stk.push(c);
            visited[c-'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty())
            sb.append(stk.pop());
        return sb.reverse().toString();
    }
}