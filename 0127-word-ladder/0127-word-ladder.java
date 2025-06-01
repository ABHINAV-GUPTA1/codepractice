class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        int depth = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            int sz = q.size();
            depth++;
            while (sz-- > 0) {
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    return depth;
                } 
                int len = curr.length();
                for (int i = 0; i < len; i++) {
                    char old = curr.charAt(i);
                    char[] arr = curr.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) {
                            continue;
                        }
                        arr[i] = c;
                        String nw = String.valueOf(arr);
                        if (nw.equals(endWord)) {
                            return depth + 1;
                        }
                        if (set.contains(nw)) {
                            q.offer(nw);
                            set.remove(nw);
                        }
                    }
                }

            }
            
        }
        return 0;
    }
}