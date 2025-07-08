class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;      // Total gas available
        int totalCost = 0;     // Total cost needed
        int tank = 0;          // Current tank level
        int startIndex = 0;    // Candidate starting station

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            tank += gas[i] - cost[i];

            // If tank drops below 0, can't start from here
            if (tank < 0) {
                startIndex = i + 1; // Try next station
                tank = 0;           // Reset tank
            }
        }

        return (totalGas >= totalCost) ? startIndex : -1;
    }
}