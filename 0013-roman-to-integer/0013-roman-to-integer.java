class Solution {
    public int romanToInt(String s) {
        
        Map<Character, Integer> map = initializeMap();
        
        int ans = 0;
        int length = s.length();
        
        ans += map.get(s.charAt(length - 1));
        
        for (int i = length - 2; i >= 0; i--) {
            int val = map.get(s.charAt(i));
            if (val < map.get(s.charAt(i+1))) {
                ans -= val; 
            } else {
                ans += val;
            }
        }

        return ans;
    }

    private Map<Character, Integer> initializeMap() {
        
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