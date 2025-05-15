//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-- > 0)
        {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
    
            ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                ArrayList<Integer> edge = new ArrayList<>();
                edge.add(u);
                edge.add(v);
                edges.add(edge);
            }
    
            Solution solution = new Solution();
            boolean result = solution.isTree(n, m, edges);
    
            if (result==true) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.size(); i++) {
            adj.get(edges.get(i).get(0)).add(edges.get(i).get(1));
            adj.get(edges.get(i).get(1)).add(edges.get(i).get(0));
        }
        
        return dfs (0, -1, adj, vis) && vis.size() == n;
    }
    
    private boolean dfs (int i, int prev, List<List<Integer>> adj, Set<Integer> vis) {
        if (vis.contains(i)) {
            return false;
        }
        
        vis.add(i);
        
        for (int v : adj.get(i)) {
            if (v == prev) {
                continue;
            }
            if (!dfs(v, i, adj, vis)) {
                return false;
            }
        }
        
        return true;
    }
}
