class Solution {

    public int countTriplets(int[] arr, int l, int r) {
        // code here
        Arrays.sort(arr);
        return countLessThan(arr, arr.length, r) - countLessThan(arr, arr.length, l-1); 
    }

    private int countLessThan(int arr[], int n, int l) {
        int ans = 0;

        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || arr[i] > arr[i-1]) {
                int j = i + 1;
                int k = n - 1;
                while (j < k) {
                    int val = arr[i]+arr[j]+arr[k];
                    if (val > l) {
                        k--;
                    } else {
                        ans += (k-j);
                        j++;
                    }
                }
            } 
        }
        return ans;
    }
}