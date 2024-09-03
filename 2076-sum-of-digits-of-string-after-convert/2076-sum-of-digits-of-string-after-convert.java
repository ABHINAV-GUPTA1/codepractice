class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            sb.append(((int)(arr[i] - 'a') + 1));
        }
        int ans = 0;
        while (k > 0) {
            int val2 = 0;
            for (int i = 0; i < sb.length(); i++) {
                val2 += (sb.charAt(i) - '0');
            }
            ans = val2;
            sb = new StringBuilder().append(val2);
            k--;
        }

        return ans;

    }
}