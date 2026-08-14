class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        // code here
        int[] a = new int[arr.length+1];
        a[0] = s;
        a[1] = a[0] + arr[0];

        for(int i = 1; i < arr.length; i++) {
            a[i+1] = a[i] - arr[i - 1] + a[i] + arr[i];
        }
        
        for(int i = a.length - 1; i >= 0; i--) {
            if(x >= a[i]) { 
                x -= a[i];
            }
            if(x == 0) {
                return true;
            }
        }

        return false;
    }
}