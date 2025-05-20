class Solution {
    public int minJumps(int[] arr) {
        int ans = 0;
        if (arr == null || arr.length < 2) {
            return 0;
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], x -> new ArrayList<>()).add(i);
        }
        q.offer(0);
        set.add(0);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int u = q.poll();
                if (u == arr.length - 1) {
                    return ans;
                }
                List<Integer> list = map.get(arr[u]);
                list.add(u + 1);
                list.add(u - 1);
                for (int v : list) {
                    if (v >= 0 && v < arr.length && u != v && !set.contains(v)) {
                        q.offer(v);
                        set.add(v);
                    }
                }
                list.clear();
            }
            ans++;
        }

        return -1;
    }
}