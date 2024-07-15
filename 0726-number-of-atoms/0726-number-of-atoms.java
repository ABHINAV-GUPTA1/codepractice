class Solution {
    public String countOfAtoms(String formula) {
        StringBuilder sb;
        int i = 0;
        int n = formula.length();
        char c;
        Stack<Map<String, Integer>> st = new Stack<>();
        Map<String, Integer> map;
        Map<String, Integer> map2;
        st.push(new HashMap<>());
        StringBuilder sb1;
        while (i < n) {
            c = formula.charAt(i);
            if (c == '(') {
                st.push(new HashMap<>());
                i++;
            } else if (c == ')'){
                map = st.pop();
                i++;
                sb = new StringBuilder();
                
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    sb.append(formula.charAt(i));
                    i++;
                }
                
                int val = 1;
                if (sb.length() > 0) {
                    val = Integer.parseInt(sb.toString());
                }
                for (String s : map.keySet()) {
                    map.put(s, map.getOrDefault(s, 0)*val);
                }
                
                map2 = st.pop();
                for (String s : map.keySet()) {
                    map2.put(s, map2.getOrDefault(s, 0)+map.get(s));
                }
                st.push(map2);
            } else {
                sb = new StringBuilder();
                sb.append(c);
                i++;
                while (i < n && formula.charAt(i) >= 'a' && formula.charAt(i) <= 'z') {
                    sb.append(formula.charAt(i));
                    i++;
                }
                sb1 = new StringBuilder();
                while (i < n && formula.charAt(i) >= '0' && formula.charAt(i) <= '9') {
                    sb1.append(formula.charAt(i));
                    i++;
                }
                int val2 = 1;
                if (sb1.length() > 0) {
                    val2 = Integer.parseInt(sb1.toString());
                }
                st.peek().put(sb.toString(), st.peek().getOrDefault(sb.toString(), 0)+val2);
            }
        }
        TreeMap<String, Integer> tmap = new TreeMap<>();
        map = st.pop();
        for (Map.Entry<String, Integer> me : map.entrySet()) {
            tmap.put(me.getKey(), me.getValue());
        } 

        sb = new StringBuilder();
        for (Map.Entry<String, Integer> me : tmap.entrySet()) {
            sb.append(me.getKey());
            if (me.getValue() > 1) {
                sb.append(me.getValue());
            }
        }
        return sb.toString();

    }
}