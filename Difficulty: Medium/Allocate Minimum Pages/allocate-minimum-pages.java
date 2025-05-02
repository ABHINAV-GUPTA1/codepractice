//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    public static int findPages(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            return -1;
        }
        int low = arr[0], high = arr[0];
        for (int i = 1; i < arr.length; i++) {
            low = Math.max(low, arr[i]);
            high += arr[i];
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (isPossible(arr, mid, k)) {
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
            if (sum + arr[i] <= mid) {
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }
        
        return count <= k;
    }
}