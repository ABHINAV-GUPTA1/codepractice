class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }

        int n = s.length();
        int idx = 0;
        while (idx < n) {
            for (int j = 0; j < numRows && idx < n; j++) {
                sb[j].append(s.charAt(idx++));
            }
            for (int j = numRows - 2; j >= 1 && idx < n; j--) {
                sb[j].append(s.charAt(idx++));
            }
        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i]);
        }

        return sb[0].toString();
    }
}