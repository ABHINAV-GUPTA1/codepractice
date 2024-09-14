class Solution {
    private Map<Integer, Integer> count;
    private Random r;
    public int[] topKFrequent(int[] nums, int k) {
        r = new Random();
        int[] res = new int[k];
        count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        int[] uq = new int[count.size()];
        int idx = 0;
        for (int u : count.keySet()) {
            uq[idx++] = u;
        }
        // System.out.println(Arrays.toString(uq));
        quickSort(uq, 0, uq.length-1, k);
        // System.out.println(Arrays.toString(uq));
        // System.out.println(count);
        for (int i = 0; i < k; i++) {
            res[i] = uq[i];
        }
        return res;
    }

    void shuffle (int arr[], int low, int high) {
        int ridx = r.nextInt(high-low+1)+low;
        int t = arr[ridx];
        arr[ridx] = arr[low];
        arr[low] = t;
    }

    private void quickSort(int[] arr, int left, int right, int k) {
        if (left > right) {
            return;
        }
        while (left <= right) {
            int part = partition(arr, left, right);
            if (part == k-1) {
                return;
            }
            if (part > k-1) {
                right = part - 1;
            } else {
                left = part + 1;
            }
        }
    }

    private int partition(int[] arr, int left, int right) {
        shuffle(arr, left, right);
        int pivot = arr[left];
        int pivotIdx = left;
        int i = left+1;
        int j = right;
        while (i <= j) {
            if ((count.get(pivot) > count.get(arr[i])) && (count.get(pivot) < count.get(arr[j]))) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
            if (count.get(pivot) <= count.get(arr[i])) {
                i++;
            }
            if (count.get(pivot) >= count.get(arr[j])) {
                j--;
            } 
        }
        int t = pivot;
        arr[left] = arr[j];
        arr[j] = t;
        return j;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        int[] res = new int[k];
        int idx = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        List<Integer>[] freq = new List[nums.length+1];
        for (int i = 0; i <= nums.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> me : map.entrySet()) {
            freq[me.getValue()].add(me.getKey());
        }
        for (int i = nums.length; i >= 0 && idx < k; i--) {
            if (freq[i].size() > 0) {
                for (int j = 0; j < freq[i].size() && idx < k; j++) {
                    res[idx++] = freq[i].get(j);
                }
            }
        }

        return res;
    }
}