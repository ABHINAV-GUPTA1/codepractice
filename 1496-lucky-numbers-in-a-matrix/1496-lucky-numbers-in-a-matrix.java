class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for (int i = 0; i < m; i++) {
            row[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                row[i] = Math.min(row[i], matrix[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            col[i] = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                col[i] = Math.max(col[i], matrix[j][i]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row[i] == matrix[i][j] && col[j] == matrix[i][j]) {
                    res.add(row[i]);
                }
            }
        }
        return res;
    }
}