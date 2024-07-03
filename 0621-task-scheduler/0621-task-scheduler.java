class Solution {
    /**
        Method 1
     */
    public int leastInterval1(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> tlist;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < tasks.length; i++) {
            map.put(tasks[i], map.getOrDefault(tasks[i], 0)+1);
        }

        for (int val : map.values()) {
            pq.offer(val);
        }

        while (!pq.isEmpty()) {
            tlist = new ArrayList<>();
            for (int i = 1; i <= n+1 && !pq.isEmpty(); i++) {
                tlist.add(pq.poll()-1);
                
            }

            for (int val : tlist) {
                if (val > 0) {
                    pq.offer(val);
                }
            }

            if (pq.isEmpty()) {
                ans += tlist.size();
            } else {
                ans += (n+1);
            }
        }

        return ans;
    }

    /**
        Method 2
     */

    public int leastInterval(char[] tasks, int n) {
        int ans = 0;
        int[] map = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            map[tasks[i]-'A']++;
        }
        Arrays.sort(map);
        ans = map[25];
        int  spaceCnt = ans-1;
        int totalSpaces = spaceCnt * n;
        for (int i = 24; i >= 0; i--) {
            totalSpaces -= Math.min(map[i], spaceCnt);
        }
        if (totalSpaces > 0) {
            return tasks.length + totalSpaces;
        }

        return tasks.length;
    }

}