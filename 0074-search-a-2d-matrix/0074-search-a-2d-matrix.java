class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length * matrix[0].length;
        int left = 0;
        int right = n-1;
        int mid;
        int m = matrix[0].length;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid/m][mid%m] == target) {
                return true;
            }
            if (matrix[mid/m][mid%m] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}