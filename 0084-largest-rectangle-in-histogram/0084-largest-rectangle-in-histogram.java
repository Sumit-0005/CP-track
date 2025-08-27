class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] prev=new int[n];
        int[] next=new int[n];
        Arrays.fill(prev,-1);
        Arrays.fill(next,n);
        Stack<Integer> s1=new Stack<>();
        for(int i=0;i<n;i++){
            while(!s1.isEmpty() && heights[i]<heights[s1.peek()]){
                int index=s1.pop();
                next[index]=i;
            }
            if(!s1.isEmpty()){
                 prev[i]=s1.peek();
            }
            s1.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
           int width=next[i]-prev[i]-1;
           int area=width*heights[i];
           ans=Math.max(ans,area);
        } 
        return ans;
    }
}