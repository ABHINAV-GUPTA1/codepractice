class Solution {
    
    int countSubarray(int A[], int L, int R) {
        int rCount = findSum(A, A.length, R);
        int lCount = findSum(A, A.length, L-1);
        return rCount - lCount;
    }
    
    int findSum(int[] arr, int n, int a) {
        int st = 0;
        int end = 0;
        int ans = 0;
        int sum = 0;
        while (end < n) {
            sum += arr[end];
            while (st <= end && sum > a) {
                sum -= arr[st++];
            }
            ans += (end - st);
            end++;
        }
        return ans;
    }
}