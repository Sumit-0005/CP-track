import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

class Solution {
    
    // A simple Fenwick Tree (Binary Indexed Tree) to track maximums
    class MaxBIT {
        int[] tree;
        int n;
        
        public MaxBIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }
        
        // Point update to a larger value
        public void update(int i, int val) {
            for (; i <= n; i += i & -i) {
                tree[i] = Math.max(tree[i], val);
            }
        }
        
        // Query the maximum value up to index i
        public int query(int i) {
            int max = 0;
            for (; i > 0; i -= i & -i) {
                max = Math.max(max, tree[i]);
            }
            return max;
        }
    }

    public List<Boolean> getResults(int[][] queries) {
        int maxX = 0;
        for (int[] q : queries) {
            maxX = Math.max(maxX, q[1]);
        }

        TreeSet<Integer> obstacles = new TreeSet<>();
        obstacles.add(0); 

        for (int[] q : queries) {
            if (q[0] == 1) {
                obstacles.add(q[1]);
            }
        }

        MaxBIT bit = new MaxBIT(maxX + 1);
        int prev = 0;
        
        for (int x : obstacles) {
            if (x == 0) continue;
            bit.update(x, x - prev);
            prev = x;
        }

        int n = queries.length;
        Boolean[] ans = new Boolean[n]; 
        for (int i = n - 1; i >= 0; i--) {
            int[] q = queries[i];
            int x = q[1];
            
            if (q[0] == 2) { 
                int sz = q[2];
                int maxGapInBIT = bit.query(x); 
                int lastObs = obstacles.floor(x);
                int currentGap = x - lastObs;
                ans[i] = Math.max(maxGapInBIT, currentGap) >= sz;
            } else { 
                obstacles.remove(x);
                Integer lower = obstacles.floor(x);
                Integer higher = obstacles.ceiling(x);
                
                if (higher != null && lower != null) {
                    bit.update(higher, higher - lower);
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (Boolean res : ans) {
            if (res != null) {
                result.add(res);
            }
        }

        return result;
    }
}