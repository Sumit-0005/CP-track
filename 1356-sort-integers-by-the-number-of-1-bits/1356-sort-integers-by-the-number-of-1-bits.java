class Solution {
    class Pair{
        int num;
        int bits;
        public Pair(int num, int bits){
            this.num = num;
            this.bits = bits;
        }
    }
    public int[] sortByBits(int[] arr) {
        int[] ans = new int[arr.length];
        List<Pair> list = new ArrayList<>();
        for(int i : arr){
            list.add(new Pair(i, Integer.bitCount(i)));
        }
        Collections.sort(list, (a,b) -> {
            if(a.bits == b.bits) return a.num - b.num;
        return a.bits - b.bits;
        });
        for(int i=0;i<arr.length;i++){
            ans[i] = list.get(i).num;
        }
    return ans;
    }
}