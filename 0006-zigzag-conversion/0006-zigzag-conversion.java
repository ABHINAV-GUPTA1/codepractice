class Solution {
    public String convert(String s, int numRows) {
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sb[i] = new StringBuilder();
        }   
        int n = s.length();
        for (int i = 0; i < n;) {
            int j = 0;
            while (j < numRows && i < n) {
                sb[j++].append(s.charAt(i++));
            }    
            j -= 2;
            while (j > 0 && i < n) {
                sb[j--].append(s.charAt(i++));
            }

        }

        for (int i = 1; i < numRows; i++) {
            sb[0].append(sb[i].toString());
        }

        return sb[0].toString();
    }
}