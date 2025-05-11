class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        
        k--;
        while (true) {
            int idx = k / fact;
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