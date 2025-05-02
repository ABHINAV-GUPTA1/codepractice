//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            int k = sc.nextInt();
            Solution obj = new Solution();
            double ans = obj.findSmallestMaxDist(a, k);
            System.out.printf("%.2f", ans);
            System.out.println();
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static double findSmallestMaxDist(int arr[], int k) {
        int n = arr.length;
        int[] howmany = new int[n-1];
        PriorityQueue<Pair<Double, Integer>> pq = 
            new PriorityQueue<>((a,b)->(Double.compare(b.first, a.first)));
        
        for (int i = 0; i < n - 1; i++) {
            pq.offer(new Pair<Double, Integer>((double) arr[i+1] - arr[i], i));
        }
        
        for (int gasStation = 1; gasStation <= k; gasStation++) {
            
            Pair<Double, Integer> pair = pq.poll();
            int secId = pair.second;
            howmany[secId]++;
            double iniDiff = arr[secId+1] - arr[secId];
            double newSection = iniDiff / (double)(howmany[secId]+1);
            
            pq.offer(new Pair<Double, Integer>(newSection, secId));
            
        }
        
        return pq.peek().first;
    }
}

class Pair<T,G> {
    T first;
    G second;
    
    Pair(T first, G second) {
        this.first = first;
        this.second = second;
    }
    
}