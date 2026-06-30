class Solution {
    public int mySqrt(int x) {
      if(x==0 || x==1) 
        return x;
      int s =1, e=x, m=-1;
      while(s<=e){
        m = s+(e-s)/2;
        if((long)m*m>(long)x)
            e = m-1;
        else if(m*m == x)
            return m;
        else
            s = m+1;        
      }  
      return Math.round(e);
    }
}