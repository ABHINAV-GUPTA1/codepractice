class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int left = 1;
        int right = Math.min(workers.length, tasks.length);
        
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(tasks, workers, mid, pills, strength)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans;
    }

    boolean isPossible(int[] tasks, int[] workers, int mid, int pills, int strength) {
        int n = tasks.length - 1;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = workers.length-mid; i < workers.length; i++) {
            map.put(workers[i], map.getOrDefault(workers[i], 0) + 1);
        }

        for (int i = mid - 1; i >= 0; i--) {
            Integer key = map.lastKey();
            if (key >= tasks[i]) {
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
            } else {
                if (pills == 0) {
                    return false;
                }
                key = map.ceilingKey(tasks[i] - strength);
                if (key == null) {
                    return false;
                }
                map.put(key, map.get(key) - 1);
                if (map.get(key) == 0) {
                    map.remove(key);
                }
                pills--;
            }
        }
        return true;
    }
}