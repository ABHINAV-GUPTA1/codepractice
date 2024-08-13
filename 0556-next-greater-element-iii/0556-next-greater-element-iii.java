class Solution {
    public int nextGreaterElement(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int i = num.length-2, j = 0;
        while (i >= 0 && num[i] >= num[i+1]) {
            i--;
        }
        if (i == -1) {
            return i;
        }
        int l1 = i;
        int l2 = num.length-1;
        while (l2 >= l1 && num[l1] >= num[l2]) {
            l2--;
        }
        char t = num[l1];
        num[l1] = num[l2];
        num[l2] = t;

        l2 = num.length-1;
        i = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= l1) {
            sb.append(num[i++]);
        }
        while (i < num.length) {
            sb.append(num[l2--]);
            i++;
        }
        long ans = Long.parseLong(sb.toString());
        return ans <= Integer.MAX_VALUE ? (int) ans : -1;
    }
}