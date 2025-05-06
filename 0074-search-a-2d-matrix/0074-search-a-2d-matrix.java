class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int high = rowLen * colLen - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int rowIdx = mid / colLen;
            int colIdx = mid % colLen;
            if (matrix[rowIdx][colIdx] == target) {
                return true;
            }
            if (matrix[rowIdx][colIdx] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }    
        return false;
    }
}