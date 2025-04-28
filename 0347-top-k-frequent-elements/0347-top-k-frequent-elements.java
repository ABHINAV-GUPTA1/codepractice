class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        List<Integer>[] listArr = new List[nums.length+1];
        for (Map.Entry<Integer, Integer> me : count.entrySet()) {
            int val = me.getValue();
            int key = me.getKey();
            if (listArr[val] == null) {
                listArr[val] = new ArrayList<>();
            }
            listArr[val].add(key);
        }

        int idx = 0;
        int[] res = new int[k];
        for (int i = listArr.length - 1; i >= 0; i--) {
            if (listArr[i] == null) {
                continue;
            }
            for (Integer tval: listArr[i]) {
                if (idx >= k) {
                    return res;
                }
                res[idx++] = tval;
            }
        }
        return res;
    }

    Map<Integer, Integer> count;
    Random r;
    public int[] topKFrequent_QuickSort(int[] nums, int k) {
        r = new Random();
        count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int idx = 0;
        int[] uq = new int[count.size()];
        for (int key : count.keySet()) {
            uq[idx++] = key;
        }
        quickSort(uq, 0, uq.length-1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = uq[i];
        }
        return res;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left > right) {
            return;
        }
        while (left <= right) {
            int partIdx = partition(arr, left, right);
            if (partIdx == k-1) {
                return;
            }
            if (partIdx > k-1) {
                right = partIdx - 1;
            } else {
                left = partIdx + 1;
            }
        }
    }

    private void shuffle(int[] arr, int left, int right) {
        int ridx = r.nextInt(right-left+1)+left;
        int t = arr[ridx];
        arr[ridx] = arr[left];
        arr[left] = t;
    }

    int partition(int[] arr, int left, int right) {
        shuffle(arr, left, right);
        int partIdx = left;
        int part = count.get(arr[left]);
        int i = left + 1;
        int j = right;
        while (i <= j) {
            if (part > count.get(arr[i]) && part < count.get(arr[j])) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
            if (count.get(arr[i]) >= part) {
                i++;
            }
            if (count.get(arr[j]) <= part) {
                j--;
            }
        }  
        int t = arr[j];
        arr[j] = arr[partIdx];
        arr[partIdx] = t;
        return j;
    }
}