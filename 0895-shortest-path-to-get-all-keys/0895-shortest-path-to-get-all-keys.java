class Solution {

    int[] dirx = {-1, 0, 1, 0};
    int[] diry = {0, 1, 0, -1};
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int keysCount = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '@') {
                    q.offer(new int[]{i, j, 0, 0}); // x,y, steps, keys_status_in_decimal
                } else if (grid[i].charAt(j) >= 'a' && grid[i].charAt(j) <= 'f') {
                    keysCount++;
                }
            }
        }
        int keysStatusDecimal = (int)Math.pow(2, keysCount)-1;

        boolean[][][] vis = new boolean[m][n][keysStatusDecimal+1];
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int i = tmp[0];
            int j = tmp[1];
            int steps = tmp[2];
            int currKeyStatus = tmp[3];
            if (currKeyStatus == keysStatusDecimal) {
                return steps;
            }
            for (int x = 0; x < dirx.length; x++) {
                int newX = i + dirx[x];
                int newY = j + diry[x];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX].charAt(newY) != '#') {
                    char ch = grid[newX].charAt(newY);
                    
                    if (ch >= 'a' && ch <= 'f') { // keys
                        int newKeyStatus = currKeyStatus | (1 << (ch-'a'));
                        if (!vis[newX][newY][newKeyStatus]) {
                            vis[newX][newY][newKeyStatus] = true;
                            q.offer(new int[]{newX, newY, steps+1, newKeyStatus});
                        }
                    } else if (ch >= 'A' && ch <= 'F') { // locks
                        int keyIdx = 1 << (ch-'a');
                        if (!vis[newX][newY][currKeyStatus] && ((currKeyStatus&keyIdx) != 0) ) {
                            vis[newX][newY][currKeyStatus] = true;
                            q.offer(new int[]{newX, newY, steps+1, currKeyStatus});
                        }
                    } else {
                        if (!vis[newX][newY][currKeyStatus]) {
                            vis[newX][newY][currKeyStatus] = true;
                            q.offer(new int[]{newX, newY, steps+1, currKeyStatus});
                        }
                    }
                }
            }
        }
        return -1;    
    }
}