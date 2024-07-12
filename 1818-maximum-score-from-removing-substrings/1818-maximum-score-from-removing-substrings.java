class Solution {
    String str;
    public int maximumGain(String s, int x, int y) {
        String s1 = "ab";
        String s2 = "ba";
        if (x < y) {
            int t = x;
            x = y;
            y = t;
            
            String ts = s1;
            s1 = s2;
            s2 = ts;
        }    
        str = s;
        return f(s1, x) + f(s2, y);
    }

    private int f(String req, int val) {
        String s = str;
        int read = 0;
        int write = 0;
        int ans = 0;
        int n = str.length();
        char[] arr = new char[n];
        while (read < n) {
            arr[write++] = s.charAt(read);
            if (write > 1 && arr[write-2] == req.charAt(0) && arr[write-1] == req.charAt(1)) {
                write -= 2;
                ans += val;
            }
            read++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < write; i++) {
            sb.append(arr[i]);
        }
        str = sb.toString();
        return ans;
    }

    private int f1(String req, int val) {
        String s = str;
        Stack<Character> st = new Stack<>();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty()) {
                st.push(s.charAt(i));
            } else {
                if (st.peek() == req.charAt(0) && s.charAt(i) == req.charAt(1)) {
                    st.pop();
                    ans += val;
                } else {
                    st.push(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }

        str = sb.toString();
        return ans;
    }


}