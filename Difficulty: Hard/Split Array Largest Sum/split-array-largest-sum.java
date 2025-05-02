//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr, int N, int K) {
        if (N < K) {
            return -1;
        } 

        int low = arr[0], high = arr[0];
        for (int i = 1; i < N; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(arr, mid, K)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isPossible(int[] arr, int mid, int k) {
        int count = 1;
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                sum = arr[i];
                count++;
            }
        }
        return count <= k;
    }
};