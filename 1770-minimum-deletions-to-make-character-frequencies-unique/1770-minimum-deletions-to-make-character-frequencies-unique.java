class Solution {
    public int minDeletions(String s) {
        int arr[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        int ans = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            while (arr[i] > 0 && set.contains(arr[i])) {
                ans++;
                arr[i]--;
            }
            set.add(arr[i]);
            
        }

        return ans;
    }
}