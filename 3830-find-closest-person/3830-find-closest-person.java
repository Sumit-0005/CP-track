class Solution {
    public int findClosest(int x, int y, int z) {
        int dxz = 0;
        int dyz = 0;
        if(x>z){
            dxz = x-z;
        }else{
            dxz = z-x;
        }
        if(z>y){
            dyz = z-y;
        }else{
            dyz = y-z;
        }
        if(dxz > dyz){
          return 2;
        }else if(dxz == dyz){
          return 0;
        }else{
            return 1;
        }
    }
}