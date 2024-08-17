class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> arr = new ArrayList<>(n);
        int[] fact = new int[n+1];
        StringBuilder sb = new StringBuilder();
        fact[0] = 1;
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            fact[i] = sum;
            arr.add(i);
        }

        k--; // as 0 based indexing
        
        for (int i = 1; i <= n; i++) {
            int idx = k / fact[n-i];
            sb.append(arr.get(idx));
            arr.remove(idx);
            k -= idx*fact[n-i];
        }

        return sb.toString();

    }
}