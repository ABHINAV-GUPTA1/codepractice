class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] vis = new boolean[arr.length + 1];

        while (!q.isEmpty()) {
            int k = q.poll();
            int val = arr[k];
            if (val == 0) {
                return true;
            }
            vis[k] = true;
            int val1 = k + val;
            int val2 = k - val;
            if (val1 >= 0 && val1 < arr.length && !vis[val1]) {
                q.offer(val1);
            }
            if (val2 >= 0 && val2 < arr.length && !vis[val2]) {
                q.offer(val2);
            }
        }
        return false;
    }
}