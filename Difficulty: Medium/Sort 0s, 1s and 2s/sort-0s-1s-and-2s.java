//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            int a[] = new int[inputArray.length];

            for (int i = 0; i < a.length; i++) a[i] = Integer.parseInt(inputArray[i]);

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
            System.out.println("~");
        }
    }
}


// } Driver Code Ends

class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(int[] arr) {
        int zeroIdx = 0;
        int midIdx = 0;
        int twoIdx = arr.length-1;
        while (midIdx <= twoIdx) {
            if (arr[midIdx] == 0) {
                swap(arr, midIdx, zeroIdx);
                zeroIdx++;
                midIdx++;
            } else if (arr[midIdx] == 1) {
                midIdx++;
            } else {
                swap(arr, midIdx, twoIdx);
                twoIdx--;
            }
        }
    }
    
    private void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }
}


//{ Driver Code Starts.
// } Driver Code Ends