class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int MOD = 1_000_000_007;
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        ArrayList<Integer> hSides = new ArrayList<>();
        ArrayList<Integer> vSides = new ArrayList<>();
        for (int hFence : hFences) {
            hSides.add(hFence);
        }
        for (int vFence : vFences) {
            vSides.add(vFence);
        }
        hSides.addFirst(1);
        hSides.addLast(m);
        vSides.addFirst(1);
        vSides.addLast(n);

        HashSet<Integer> hSet = new HashSet<>();
        long maxArea = -1;
        long maxSideH = -1;
        for (int i = 0; i < hSides.size(); i++) {
            for(int j = i+1; j < hSides.size(); j++) {
                hSet.add(hSides.get(j) - hSides.get(i));
            }
        }
        for (int i = 0; i < vSides.size(); i++) {
            for (int j = i+1; j < vSides.size(); j++) {
                int sideV = vSides.get(j) - vSides.get(i);
                if(hSet.contains(sideV)) {
                    maxSideH = Math.max(maxSideH, sideV);
                }
            }
        }
        if(maxSideH == -1) {
            return -1;
        } else {
            return (int) ((maxSideH * maxSideH)%MOD);
        }
    }
}