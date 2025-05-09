class Solution {
    /**
        Method 2 : 
            TC = O(n! * n)
            SC = O(n)  
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] arr, int idx, List<Integer> tmp, List<List<Integer>> res) {
        if (idx == arr.length) {
            tmp.clear();
            for (int i = 0; i < arr.length; i++) {
                tmp.add(arr[i]);
            }
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            backtrack(arr, idx + 1, tmp, res);
            swap(arr, i, idx);
        }
    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    /**
        Method 1 : 
            TC = O(n! * n)
            SC = O(n) + O(n) 
     */
    public List<List<Integer>> permute_method1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(nums, vis, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] arr, boolean[] vis, List<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!vis[i]) {
                vis[i] = true;
                tmp.add(arr[i]);
                dfs(arr, vis, tmp, res);
                tmp.remove(tmp.size() - 1);
                vis[i] = false;
            }
        }
    }
}