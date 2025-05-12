class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            nums.add(i);
            fact *= i;
        }
        nums.add(n);
        k--; // as we will use 0 based indexing
        StringBuilder sb = new StringBuilder();
        while (true) {
            int idx = k/fact;
            sb.append(nums.get(idx));
            nums.remove(idx);
            if (nums.size() == 0) {
                return sb.toString();
            }
            k = k % fact;
            fact = fact / nums.size();
        }
        
    }
}