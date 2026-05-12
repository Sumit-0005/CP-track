class Solution {
    public int minimumEffort(int[][] tasks) {
        int energy = 0;
        int extraEnergyAdded = 0;
        Collections.sort(java.util.Arrays.asList(tasks), (a, b) -> a[1] - a[0] == b[1] - b[0] ? a[1] - b[1] : (b[1] - b[0]) - (a[1] - a[0]));
        for (int[] task : tasks) {
            if (energy < task[1]) {
                extraEnergyAdded += task[1] - energy;
                energy = task[1];
            }
            energy -= task[0];
        }
        return extraEnergyAdded;
    }
}