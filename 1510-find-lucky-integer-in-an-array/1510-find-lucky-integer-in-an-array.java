class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = -1;

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            if (me.getKey() == me.getValue()) {
                ans = Math.max(ans, me.getKey());
            }
        }

        return ans;
    }
}