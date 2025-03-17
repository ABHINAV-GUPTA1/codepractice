//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        boolean[] old = new boolean[sum+1];
        old[0] = true;
        if (arr[0] <= sum)
            old[arr[0]] = true;
        for (int i = 1; i < arr.length; i++) {
            boolean[] curr = new boolean[sum+1];
            curr[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean ntake = old[j];
                boolean take = false;
                if (j >= arr[i]) {
                    take = old[j-arr[i]];
                }
                curr[j] = take || ntake;
            }
            old = curr;
        }
        
        return old[sum];
        
    }
    
    static boolean f(int arr[], int idx, int target) {
        if (target == 0) {
            return true;
        }
        if (idx == 0) {
            return arr[idx] == target;
        }
        boolean ntake = f(arr, idx-1, target);
        boolean take = false;
        if (target >= arr[idx]) {
            take = f(arr, idx-1, target-arr[idx]);
        }
        return take || ntake;
    }
}