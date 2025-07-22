class Solution {
    public int missingNumber(int[] arr) {
        boolean isOne = false;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                isOne = true;
            }
            if (arr[i] < 1 || arr[i] > n) {
                arr[i] = 1;
            }
        }
        
        if (!isOne) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) {
                continue;
            }
            arr[idx] = -arr[idx];
        }
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                return i + 1;
            }
        }
        
        return n + 1;
        
    }
}
