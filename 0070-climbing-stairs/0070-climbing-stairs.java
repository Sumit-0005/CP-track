class Solution {
    int  back(int cur,int[] temp)
    {
        if(cur==0)
        {
            return 1;
        }
        if(cur<0)
        {
            return 0;
        }
        if(temp[cur-1]!=-1)
        {
            return temp[cur-1];
        }
        int one=back(cur-1,temp);
        int twostep=back(cur-2,temp);
        temp[cur-1]=one+twostep;
        return one +twostep;
    }
    public int climbStairs(int n) {
        int[] temp =new int[n];
        for(int i=0;i<n;i++)
        {
            temp[i]=-1;
        }
        int res=back(n, temp); 
        return res;
    }
}