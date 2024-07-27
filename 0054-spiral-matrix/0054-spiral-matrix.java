class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        while (i < m && j < n) {
            for (int k = j; k < n; k++) {
                res.add(matrix[i][k]);
            }
            i++;
            for (int k = i; k < m; k++) {
                res.add(matrix[k][n-1]);
            }
            n--;
            if (!(i < m && j < n)) {
                break;
            }
            for (int k = n-1; k >= j; k--) {
                res.add(matrix[m-1][k]);
            }
            m--;
            for (int k = m-1; k >= i; k--) {
                res.add(matrix[k][j]);
            }
            j++;
        }
        return res;
    }
}