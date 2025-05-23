//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int x = V;
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());

            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                adj.get(edges[i][0]).add(edges[i][1]);
            }

            ArrayList<Integer> res = new Solution().topoSort(V, edges);

            if (check(adj, x, res) == true)
                System.out.println("true");
            else
                System.out.println("false");
            System.out.println("~");
        }
    }

    static boolean check(ArrayList<ArrayList<Integer>> adj, int V,
                         ArrayList<Integer> res) {

        if (V != res.size()) return false;

        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res.get(i)] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


class Solution {
    
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] in = new int[V];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        for (int i = 0; i < edges.length; i++) {
            in[edges[i][1]]++;
        }
        
        for (int i = 0; i < V; i++) {
            if (in[i] == 0) {
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (--in[v] == 0) {
                    q.offer(v);
                }
            }
            res.add(u);
        }
        
        
        return res;
    }
    
    public static ArrayList<Integer> topoSort1(int V, int[][] edges) {
        ArrayList<Integer> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, st);
            }
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
        return res;
    }
    
    private static void dfs (List<List<Integer>> adj, int i, boolean[] vis, Stack<Integer> st) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        for (int child : adj.get(i)) {
            if (!vis[child]) {
                dfs(adj, child, vis, st);
            }
        }
        
        st.push(i);
    }
}