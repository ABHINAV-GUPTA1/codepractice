class Solution {
    LinkedList<String> res;
    int n;
    Map<String, PriorityQueue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        res = new LinkedList<>();
        n = tickets.size()+1;
        map = new HashMap<>();

        for (int i = 0; i < tickets.size(); i++) {
            map.computeIfAbsent(tickets.get(i).get(0), x->new PriorityQueue<>()).offer(tickets.get(i).get(1));
        }
        
        
        dfs("JFK");
        
        return res;
    }

    private void dfs(String src) {
        PriorityQueue<String> pq = map.get(src);
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll());
        }
        res.addFirst(src);
    }
}