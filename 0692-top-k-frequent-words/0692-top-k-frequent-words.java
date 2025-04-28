
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)-> {
            int c1 = map.get(a);
            int c2 = map.get(b);
            if (c1 == c2) {
                return b.compareTo(a);
            }
            return c1 - c2;
        });
        for (String key : map.keySet()) {
            pq.offer(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }
}