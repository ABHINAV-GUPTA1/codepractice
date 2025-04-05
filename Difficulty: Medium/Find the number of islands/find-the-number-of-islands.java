//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] grid = new char[n][m];

            // Read the grid input
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = scanner.next().charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.countIslands(grid);
            System.out.println(ans);
            System.out.println("~");
        }
        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    public int countIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
       boolean visited[][] = new boolean[N][M];
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 'L' && !visited[i][j]) {
                    DFS(grid, i, j, visited, N, M);
                    count++;
                }
            }
        }
        
        return count;
        
    }
    
    private boolean isSafe(char[][] list, int r, int c, boolean[][] visited, int N, int M) {
        return (r >= 0) && (r < N) && (c >= 0) && (c < M) && (list[r][c] == 'L') && (!visited[r][c]);
    }
    
    private void DFS(char[][] list, int r, int c, boolean[][] visited, int N, int M) {
        
        visited[r][c] = true;
        
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isSafe(list, r+i, c+j, visited, N, M)) {
                    DFS(list, r+i, c+j, visited, N, M);
                }
            }
        }
        
    }
}