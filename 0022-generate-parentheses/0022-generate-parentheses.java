class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(0, 0, n, "", res);
        return res;
    }

    private void generate(int open, int close, int n, String s, List<String> res) {
        if (s.length() == n*2) {
            res.add(s);
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        if (open < n) {
            sb.append("(");
            generate(open+1, close, n, sb.toString(), res);
            sb.setLength(sb.length()-1);
        }
        if (close < open) {
            sb.append(")");
            generate(open, close+1, n, sb.toString(), res);
        }
    }
}