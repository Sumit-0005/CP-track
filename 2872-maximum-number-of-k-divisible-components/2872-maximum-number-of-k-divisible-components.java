class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        componentCount = 0;
        dfs(graph, 0, -1, values, k);
        return componentCount;
    }
    private int componentCount = 0;
    private long dfs(List<Integer>[] graph, int currentNode, int parent, int[] values, int k) {
        long subtreeSum = values[currentNode];
        for (int neighbor : graph[currentNode]) {
            if (neighbor != parent) {
                subtreeSum += dfs(graph, neighbor, currentNode, values, k);
            }
        }
        if (subtreeSum % k == 0) {
            componentCount++;
        } 
        return subtreeSum;
    }
}