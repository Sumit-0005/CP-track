class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int ans = 0;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());

        for (int[] i : allowedSwaps) {
            graph.get(i[0]).add(i[1]);
            graph.get(i[1]).add(i[0]);
        }

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                List<Integer> conn = new ArrayList<>();

                dfs(graph, visited, conn, i);

                Map<Integer, Integer> map = new HashMap<>();

                for (int j : conn) 
                    map.put(source[j], map.getOrDefault(source[j], 0) + 1); 
                
                for (int j : conn) 
                    if (map.getOrDefault(target[j], 0) >= 1)
                        map.put(target[j], map.get(target[j]) - 1);
                    else
                        ans += 1;
                
            }
        }
        return ans;
    }
    public void dfs(List<List<Integer>> graph, int[] visited, List<Integer> conn, int idx) {
        visited[idx] = 1;
        conn.add(idx);
        for (int i : graph.get(idx))
            if (visited[i] == 0)
                dfs(graph, visited, conn, i);
       
    }
}