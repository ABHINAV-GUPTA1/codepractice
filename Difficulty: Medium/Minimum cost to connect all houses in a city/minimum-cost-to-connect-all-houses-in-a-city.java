//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] edge = new int[n][2];
            for (int i = 0; i < n; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minCost(edge);

            System.out.println(res);
            System.out.println("~");
        }
    }
}

// } Driver Code Ends




class Solution {

    static class Edge{
        int src;
        int dest;
        int wt;
        public Edge(int src,int dest,int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    static class Pair{
        int node;
        int cost;
        public Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
    }
    private void createGraph(int[][] houses,ArrayList<Edge>[] graph){
        for(int i=0;i<graph.length;i++) graph[i]=new ArrayList<>();
        for(int i=0;i<houses.length-1;i++){
            int src=i;
            for(int j=i+1;j<houses.length;j++){
                int dest=j;
                int x1=houses[i][0];
                int y1=houses[i][1];
                int x2=houses[j][0];
                int y2=houses[j][1];
                int dist=Math.abs(x1-x2)+Math.abs(y1-y2);
                graph[src].add(new Edge(src,dest,dist));
                graph[dest].add(new Edge(dest,src,dist));
            }
        }
    }
    public int minCost(int[][] houses) {
        // code here
        int n=houses.length;
        ArrayList<Edge>[] graph=new ArrayList[n];
        createGraph(houses,graph);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.cost-b.cost);
        pq.add(new Pair(0,0));
        boolean[] vis=new boolean[n];
        int cost=0;
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!vis[curr.node]){
                vis[curr.node]=true;
                cost+=curr.cost;
                for(Edge e:graph[curr.node]){
                    if(!vis[e.dest]) pq.add(new Pair(e.dest,e.wt));
                }
            }
        }
        return cost;
    }
}
