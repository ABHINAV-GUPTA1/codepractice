class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = getMap();
        int res = 0;
        int n = s.length()-1;
        int curr;
        int prev = map.get(s.charAt(n--));
        res = prev;
        for (int i = n; i >= 0; i--) {
            curr = map.get(s.charAt(i));
            if (prev <= curr) {
                res += curr;
            } else {
                res -= curr;
            }

            prev = curr;
        }

        return res;
    }

    private Map<Character, Integer> getMap() {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

}