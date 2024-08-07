class Solution {
    public int partitionString(String s) {
        if (s == null || s.length() < 2) {
            return 1;
        }
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        int count = 0;
        int start = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i)-'a';
            if (arr[idx] >= start) {
                count++;
                start = i;
            }
            arr[idx] = i;
        }

        return count+1;
    }
}