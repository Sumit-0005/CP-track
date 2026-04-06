class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Store obstacles in a HashSet for O(1) membership test
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            // Convert each obstacle coordinate to a unique string "x,y"
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        // Starting position
        int x = 0, y = 0;
        // Direction index: 0 = north, 1 = east, 2 = south, 3 = west
        int dirIdx = 0;
        // Direction vectors: north, east, south, west
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int maxDist = 0;
        
        // Process each command
        for (int cmd : commands) {
            if (cmd == -2) {
                // Turn left: decrease index, wrap around with +4
                dirIdx = (dirIdx - 1 + 4) % 4;
            } else if (cmd == -1) {
                // Turn right: increase index
                dirIdx = (dirIdx + 1) % 4;
            } else {
                // Move forward 'cmd' steps, one at a time
                int dx = dirs[dirIdx][0];
                int dy = dirs[dirIdx][1];
                
                for (int step = 0; step < cmd; step++) {
                    int nextX = x + dx;
                    int nextY = y + dy;
                    
                    // If the next cell contains an obstacle, stop moving
                    if (obstacleSet.contains(nextX + "," + nextY)) {
                        break;
                    }
                    
                    // Otherwise, move and update max distance
                    x = nextX;
                    y = nextY;
                    maxDist = Math.max(maxDist, x*x + y*y);
                }
            }
        }
        
        return maxDist;
    }
}