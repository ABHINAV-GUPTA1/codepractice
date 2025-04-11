//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int V = Integer.parseInt(sc.nextLine());
            int E = Integer.parseInt(sc.nextLine());

            List<int[]> edgeList = new ArrayList<>();

            for (int i = 0; i < E; i++) {
                String[] parts = sc.nextLine().split(" ");
                int u = Integer.parseInt(parts[0]);
                int v = Integer.parseInt(parts[1]);
                int w = Integer.parseInt(parts[2]);
                edgeList.add(new int[] {u, v, w});
                edgeList.add(new int[] {v, u, w});
            }

            int[][] edges = new int[edgeList.size()][3];
            for (int i = 0; i < edgeList.size(); i++) {
                edges[i] = edgeList.get(i);
            }

            int src = Integer.parseInt(sc.nextLine());

            Solution obj = new Solution();
            int[] res = obj.dijkstra(V, edges, src);

            for (int val : res) {
                System.out.print(val + " ");
            }
            System.out.println();
            System.out.println("~");
        }

        sc.close();
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static class Node{
        int src,dest,wt;
        public Node(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static class Pair{
        int node,cost;
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<Node>[] graph=new ArrayList[V];
        int[] dist=new int[V];
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++) dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        for(int i=0;i<V;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            int source=edge[0];
            int dest=edge[1];
            int wt=edge[2];
            graph[src].add(new Node(source,dest,wt));
            graph[dest].add(new Node(dest,source,wt));
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(visited[curr.node]) continue;
            visited[curr.node]=true;
            for(Node node:graph[curr.node]){
                int u=node.src;
                int v=node.dest;
                int wt=node.wt;
                if(dist[u]+wt<dist[v]&&dist[u]!=Integer.MAX_VALUE){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        
        return dist;
    }
}