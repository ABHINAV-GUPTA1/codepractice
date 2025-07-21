class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() < 2) {
            return s;
        }
        sb.append(s.charAt(0));
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
                if (count <= 1) {
                    sb.append(s.charAt(i));
                }
                count++;
            } else {
                sb.append(s.charAt(i));
                count = 1;
            }
        }    

        return sb.toString();
    }
}