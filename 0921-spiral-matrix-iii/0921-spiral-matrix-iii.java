class Solution {
    private static int dirArr[][] = {{0,1},{1,0}, {0,-1},{-1, 0}};
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int total = rows*cols;
        int[][] res = new int[total][2];
        int idx = 0;
        for (int steps = 1, dir = 0; idx < total;) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < steps; j++) {
                    if (rStart >= 0 && cStart >= 0 && rStart < rows && cStart < cols) {
                        res[idx][0] = rStart;
                        res[idx][1] = cStart;
                        idx++;
                    } 
                    rStart += dirArr[dir][0];
                    cStart += dirArr[dir][1];
                }
                dir = (dir+1)%4;
            }
            steps++;
        }

        return res;
    }
}