class Solution {

    /**
        Using BiFunction and Map
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        Map<Character, BiFunction<Integer, Integer, Integer>> map = initializeBiFunctionMap();
        for (String token : tokens) {
            char c = token.charAt(token.length()-1);
            if (Character.isDigit(c)) {
                st.push(Integer.parseInt(token));
            } else {
                int b = st.pop();
                int a = st.pop();
                st.push(map.get(c).apply(a, b));
            }
        }

        return st.pop();
    }

    private Map<Character, BiFunction<Integer, Integer, Integer>> initializeBiFunctionMap() {
        
        Map<Character, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        map.put('+', (a,b)->a+b);
        map.put('-', (a,b)->a-b);
        map.put('*', (a,b)->(int)((long)a*b));
        map.put('/', (a,b)->a/b);
        
        return map;
    }

    /**
        Basic Approach
     */
    public int evalRPN_method1(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(token.length()-1);
            if (Character.isDigit(c)) {
                st.push(Integer.parseInt(token));
            } else {
                int b = st.pop();
                int a = st.pop();
                if (c == '+') {
                    st.push(a + b);
                } else if (c == '-') {
                    st.push(a - b);
                } else if (c == '*') {
                    st.push((int) ((long) a * b));
                } else {
                    st.push(a/b);
                }
            }
        }

        return st.pop();
    }
}