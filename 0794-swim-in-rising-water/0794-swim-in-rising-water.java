class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[2]-b[2]));
        pq.offer(new int[]{0, 0, grid[0][0]});
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            if (arr[0] == n-1 && arr[1] == n-1) {
                return arr[2];
            }
            if (vis[arr[0]][arr[1]]) {
                continue;
            }
            vis[arr[0]][arr[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + arr[0];
                int ny = dy[i] + arr[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || vis[nx][ny]) {
                    continue;
                }
                pq.offer(new int[]{nx, ny, Math.max(grid[nx][ny], arr[2])});
            }
        }

        return 0;
    }
}