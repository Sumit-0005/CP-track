class Solution {
    public double angleClock(int hour, int minutes) {
        double x = (hour%12)*30 + minutes/2.0;
        double y = minutes*6;
        double angle = Math.abs(x-y);
        return Math.min(angle, 360-angle);
    }
}