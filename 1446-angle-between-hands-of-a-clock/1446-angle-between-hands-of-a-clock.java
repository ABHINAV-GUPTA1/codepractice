class Solution {
    public double angleClock(int hour, int minutes) {
        double hr = (hour*60 + minutes)*0.5;
        double min = (minutes*6);

        double ans = Math.abs(hr-min);
        if (ans <= 180) {
            return  ans;
        }

        return 360-ans;

    }
}