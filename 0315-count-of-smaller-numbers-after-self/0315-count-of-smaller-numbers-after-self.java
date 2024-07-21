class Solution {
    class Pair {
        int idx;
        int val;
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] pair = new Pair[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair(i, nums[i]);
        }
        int[] ans = new int[n];
        mergeSort(0, n-1, pair, ans);
        List<Integer> alist = new ArrayList();
        for (int i = 0; i < ans.length; i++) {
            // System.out.println(pair[i].idx +" "+pair[i].val);
            alist.add(ans[i]);
        }
        return alist;
    }

    private void mergeSort(int left, int right, Pair[] p, int[] ans) {
        if (left >= right) {
            return;
        }
        int mid = left+(right-left) / 2;
        mergeSort(left, mid, p, ans);
        mergeSort(mid+1, right, p, ans);
        merge(left, mid, right, p, ans);
    }

    private void merge(int left, int mid, int right, Pair[] p, int[] ans) {
        Pair[] tmp = new Pair[right-left+1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <=right) {
            if (p[i].val > p[j].val) {
                tmp[k++] = new Pair(p[i].idx, p[i].val);
                ans[p[i].idx] += right - j + 1;
                i++;
            } else {
                tmp[k++] = new Pair(p[j].idx, p[j].val);
                j++;
            }
        } 

        while (i <= mid) {
            tmp[k++] = new Pair(p[i].idx, p[i].val);
            i++;
        }

        while (j <= right) {
            tmp[k++] = new Pair(p[j].idx, p[j].val);
            j++;
        }
        for (i = left; i <= right; i++) {
            p[i].idx = tmp[i-left].idx;
            p[i].val = tmp[i-left].val;
        }
    }
}