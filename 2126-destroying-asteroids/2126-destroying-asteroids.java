class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currMass = mass;
        for(int asteriod: asteroids){
            if(asteriod > currMass){
                return false;
            }
            currMass += asteriod;
        }
        return true;
    }
}