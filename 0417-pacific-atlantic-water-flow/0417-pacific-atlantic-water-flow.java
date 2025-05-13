class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        Queue<int[]> pacificQ = new LinkedList<>();
        Queue<int[]> atlanticQ = new LinkedList<>();

        boolean[][] pacificVis = new boolean[r][c];
        boolean[][] atlanticVis = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            pacificQ.offer(new int[]{i, 0});
            atlanticQ.offer(new int[]{i, c - 1});
            pacificVis[i][0] = true;
            atlanticVis[i][c - 1] = true;
        }

        for (int i = 0; i < c; i++) {
            pacificQ.offer(new int[]{0, i});
            atlanticQ.offer(new int[]{r - 1, i});
            pacificVis[0][i] = true;
            atlanticVis[r - 1][i] = true;
        }
        bfs(heights, pacificQ, pacificVis);
        bfs(heights, atlanticQ, atlanticVis);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (pacificVis[i][j] && atlanticVis[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    private void bfs (int[][] hts, Queue<int[]> q, boolean[][] vis) {
        int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int r = hts.length, n = hts[0].length;
        while (!q.isEmpty()) {
            int[] qData = q.poll();
            for (int[] d : dir) {
                int x = qData[0] + d[0];
                int y = qData[1] + d[1];

                if (x < 0 || y < 0 || x >= r || y >= n || vis[x][y] || hts[x][y] < hts[qData[0]][qData[1]]) {
                    continue;
                }
                vis[x][y] = true;
                q.offer(new int[] {x, y});
            }
        }   
    }
}