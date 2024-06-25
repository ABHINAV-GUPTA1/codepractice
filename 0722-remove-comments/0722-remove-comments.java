class Solution {
    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<>();
        int n = source.length;
        String s;
        int m;
        boolean blocked = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            s = source[i];
            m = s.length();
            for (int j = 0; j < m; j++) {
                
                if (blocked) {
                    if (s.charAt(j) == '*' && j+1 < m && s.charAt(j+1) == '/')  {
                        blocked = false;
                        j++;
                    }
                } else {
                    if (s.charAt(j) == '/' && j+1 < m && s.charAt(j+1) == '*') {
                        blocked = true;
                        j++;
                    } else if (s.charAt(j) == '/' && j+1<m && s.charAt(j+1) == '/') {
                        break;
                    } else {
                        sb.append(s.charAt(j));
                    }
                }
            }
            if (!blocked && sb.length() > 0) {
                res.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return res;
    }
}