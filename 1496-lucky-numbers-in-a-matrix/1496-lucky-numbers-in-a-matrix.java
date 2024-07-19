class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] ans = new int[matrix.length];
        int m = matrix.length;
        int n = matrix[0].length;

        int mx[] = new int[m];
        int my[] = new int[n];
        Arrays.fill(mx, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mx[i] = Math.min(mx[i], matrix[i][j]);
                my[j] = Math.max(my[j], matrix[i][j]);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) { 
                if (mx[i] == my[j]) {
                    res.add(mx[i]);
                    break;
                }
            } 
        }

        return res;
    }
}