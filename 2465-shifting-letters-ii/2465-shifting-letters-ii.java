class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] diffArr = new int[s.length()];

        for (int i = 0; i < shifts.length; i++) {
            diffArr[shifts[i][0]] += ((shifts[i][2] == 0) ? -1 : 1);
            if (shifts[i][1] + 1 < diffArr.length) {
                diffArr[shifts[i][1]+1] += ((shifts[i][2] == 0) ? 1 : -1);
            }
        } 
        for (int i = 1; i < diffArr.length; i++) {
            diffArr[i] += diffArr[i-1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int val = ((s.charAt(i)-'a')+diffArr[i])%26;
            if (val < 0) {
                val = (val + 26);
            }
            sb.append((char)(val+'a'));
        }
        return sb.toString();
    }
}