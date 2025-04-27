class Solution {
    /**
        2 step process
        1. Transpose
        2. Reverse
     */
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // Transpose
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }

        //reverse the matrix
        for (int i = 0; i < m; i++) {
            reverse(matrix[i]);
        }
    }

    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
    }
}