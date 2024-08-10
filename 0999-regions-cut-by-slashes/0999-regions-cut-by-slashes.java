/**
    "/" -> i,j => (i,j+1) & (i+1, j) ]
                                       => 4*i + j => cell number                 
    "\" -> i,j => (i,j) & (i+1, j+1) ]
 */
class Solution {
    int[] parent;
    int[] rank;

    private int find(int x) {
        if (parent[x] != x) {
            return parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    // union and return count if cycle found
    private int union(int x, int y) {
        int fx = find(x);
        int fy = find(y);
        if (fx != fy) {
            if (rank[fx] > rank[fy]) {
                parent[fy] = fx;
                rank[fx]++;
            } else if (rank[fx] < rank[fy]) {
                parent[fx] = fy;
                rank[fy]++;
            } else {
                parent[fx] = fy;
                rank[fy]++;
            }
            return 0; 
        } else {
            return 1;
        }
    }

    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int dots = n + 1;
        parent = new int[dots*dots];
        rank = new int[dots*dots];
        int count = 1; // for initial square cycle

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                if (i == 0 || j == 0 || i == dots-1 || j == dots-1) {
                    int cellnumber = i*dots + j;
                    if (cellnumber != 0) {
                        count += union(0, cellnumber);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                if (grid[i].charAt(j) == '/') {
                    int c1 = dots*i + (j+1);// (i, j+1);
                    int c2 = dots* (i+1) + j; // (i+1, j);
                    count += union(c1, c2);
                } else if (grid[i].charAt(j) == '\\') {
                    int c1 = dots*i + (j);// (i, j);
                    int c2 = dots* (i+1) + j+1; // (i+1, j+1);
                    count += union(c1, c2);
                }
            }
        }

        return count;

    }
}