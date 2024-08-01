class Solution {
    public int secondsToRemoveOccurrences(String s) {
        char[] arr = s.toCharArray();
        int n  = arr.length;
        int ans = 0;
        boolean flag;
        while (true) {
            flag = false;
            for (int i = 1; i < n; i++) {
                if (arr[i-1] == '0' && arr[i] == '1') {
                    flag = true;
                    arr[i-1] = '1';
                    arr[i] = '0';
                    i++;
                }
            }
            if (!flag) {
                return ans;
            }
            ans++;
        }    
    }
}