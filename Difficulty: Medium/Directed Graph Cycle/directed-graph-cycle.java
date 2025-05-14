//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int[] in = new int[V];
        int count = 0;
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            in[e[1]]++;
        }
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int u = q.poll();
            count++;
            for (int v : adj.get(u)) {
                if (--in[v] == 0) {
                    q.offer(v);
                }
            }
        }
        return count != V;
    }
}