class Solution {
    public int minimumPushes(String word) {
        int[] arr = new int[26];
        for (char c : word.toCharArray()) {
            arr[c-'a']++;
        }
        // arr = Arrays.stream(arr).boxed().sorted((a,b)->b-a).mapToInt(Integer::intValue).toArray();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for (int i = 0; i < 26; i++) {
            if (arr[i]>0) {
                pq.offer(arr[i]);
            }
        }
        int ans = 0;
        int k = 0;
        int val = 1;
        // while (k < 26) {
        //     for (int i = 2; i <= 9 && k < 26; i++) {
        //         ans += (arr[k++]*val);
        //     }
        //     val++;
        // }
        while (!pq.isEmpty()) {
            for (int i = 2; i <= 9 && !pq.isEmpty(); i++) {
                ans += (pq.poll()*val);
            }
            val++;
        }
        return ans;
    }
}