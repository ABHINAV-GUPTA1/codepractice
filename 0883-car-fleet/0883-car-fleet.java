class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> st = new Stack<>();
        int len = position.length;
        double[][] carData = new double[len][2];
        
        // carData[i][0] => pos
        // carData[i][1] => time
        for (int i = 0; i < len; i++) {
            carData[i][0] = (double) position[i];
            carData[i][1] = ((double) target - position[i]) / speed[i];
        }

        Arrays.sort(carData, (a, b) -> Double.compare(a[0], b[0]));
        double prev = -1;
        for (int i = len - 1; i >= 0; i--) {
            
            if (!st.isEmpty() && carData[i][1] <= st.peek()) {
                continue;
            }
            st.push(carData[i][1]);
        }

        return st.size();
    }

    public int carFleet_method1(int target, int[] position, int[] speed) {
        
        int len = position.length;
        double[][] carData = new double[len][2];

        // carData[i][0] => pos
        // carData[i][1] => time
        for (int i = 0; i < len; i++) {
            carData[i][0] = (double) position[i];
            carData[i][1] = ((double) target - position[i]) / speed[i];
        }

        Arrays.sort(carData, (a, b) -> Double.compare(a[0], b[0]));
        
        int numberOfFleet = 1;
        double timeTaken = carData[len - 1][1];

        for (int i = len - 2; i >= 0; i--) {
            if (carData[i][1] > timeTaken) {
                timeTaken = carData[i][1];
                numberOfFleet++;
            }
        }

        return numberOfFleet;
    }
}