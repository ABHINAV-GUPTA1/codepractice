class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = 0;
        int close = 0;
        generate("", n, open, close, res);
        return res;
    }

    private void generate(String str, int n, int open, int close, List<String> res) {
    
        if (str.length() == 2*n) {
            res.add(str);
            return;
        }
        if (open < n) {
            generate(str+"(", n, open + 1, close, res);
        }
        if (close < open) {
            generate(str+")", n, open, close + 1, res);
        }
    }
}