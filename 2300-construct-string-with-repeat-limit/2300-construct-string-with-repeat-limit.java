class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            return Integer.compare(b[0],a[0]);
        });
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] > 0) {
                pq.offer(new int[]{i, arr[i]});
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] val1 = pq.poll();
            char ch = (char)(val1[0] + 'a');
            int limit = Math.min(val1[1], repeatLimit);
            for (int i = 0; i < limit; i++) {
                sb.append(ch);
            }
            val1[1] -= limit;
            if (val1[1] > 0 && !pq.isEmpty()) {
                int[] val2 = pq.poll();
                ch = (char)(val2[0]+'a');
                sb.append(ch);
                val2[1] -= 1;
                if (val2[1] > 0) {
                    pq.offer(val2);
                }
                pq.offer(val1);
            }
        }
        return sb.toString();
    }
}