class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums, k) - f(nums, k-1);
    }
    
    private int f(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int n = arr.length;
        int ans = 0;
        while (r < n) {
            int cnt = map.getOrDefault(arr[r], 0);
            map.put(arr[r], cnt+1);
            while (map.size() > k) {
                cnt = map.get(arr[l]);
                if (cnt == 1) {
                    map.remove(arr[l]);
                } else {
                    map.put(arr[l], cnt-1);
                }
                l++;
            }
            ans += (r-l+1);
            r++;
        }
        return ans;
    }
}