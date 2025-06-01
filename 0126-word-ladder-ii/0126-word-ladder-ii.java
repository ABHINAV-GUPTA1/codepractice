class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        
        boolean isPossible = bfs (beginWord, endWord, map, set);
        if (!isPossible) {
            return res;
        }
        dfs(endWord, beginWord, new ArrayList<>(), map, res);
        return res;
    }

    private void dfs (String bw, String ew, List<String> path, Map<String, List<String>> map, List<List<String>> res) {
        path.add(bw);
        if (bw.equals(ew)) {
            List<String> tlist = new ArrayList<>(path);
            Collections.reverse(tlist);
            res.add(tlist);
            return;
        }
        for (String nw : map.get(bw)) {
            dfs (nw, ew, path, map, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean bfs (String bw, String ew, Map<String, List<String>> map, Set<String> set) {
        Queue<String> q = new LinkedList<>();
        q.offer(bw);
        Map<String, Integer> dist = new HashMap<>();
        int level = 0;
        boolean isPossible = false;
        dist.put(bw, 0);
        
        while (!q.isEmpty()) {
            int sz = q.size();
            level++;
            while (sz-- > 0) {
                String curr = q.poll();
                char[] arr = curr.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        arr[i] = c;
                        String nw = String.valueOf(arr);
                        if (!set.contains(nw)) {
                            continue;
                        }
                        if (!dist.containsKey(nw)) {
                            dist.put(nw, level);
                            map.computeIfAbsent(nw, x -> new ArrayList<>()).add(curr);
                            q.offer(nw);
                        } else if (dist.get(nw) - dist.get(curr) == 1) {
                            map.computeIfAbsent(nw, x -> new ArrayList<>()).add(curr);
                        }
                        if (nw.equals(ew)) {
                            isPossible = true;
                        }
                    }
                    arr[i] = old;
                }
            }
        }

        return isPossible;
    }
}