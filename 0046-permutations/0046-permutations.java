class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        dfs(0, nums);
        return res;
    }

    private void dfs(int idx, int[] arr) {
        if (idx == arr.length) {
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                tmp.add(arr[i]);
            }
            res.add(tmp);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            swap(arr, i, idx);
            dfs(idx+1, arr);
            swap(arr, i, idx);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    public List<List<Integer>> permute1(int[] nums) {
        res = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums, vis, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] arr, boolean[] vis, List<Integer> tmp) {
        
        if (tmp.size() == arr.length) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (vis[i]) {
                continue;
            }
            tmp.add(arr[i]);
            vis[i] = true;
            backtrack(arr, vis, tmp);
            vis[i] = false;
            tmp.remove(tmp.size()-1);
        }
    }
}