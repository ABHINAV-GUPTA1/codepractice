
//
// 4 |  5 |  6 |  7 => 240
// 67 89=>960
// 2345=>60
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int rs[] : reservedSeats) {
            int r = rs[0];
            int c = rs[1];
            map.put(r, map.getOrDefault(r, 0)| (1<<c) );
        }
        
        int ans = 0;
        for (int s : map.keySet()) {
            int rs = map.get(s);
            int c = 0;
            if ((rs & 60) == 0)
                c += 1;
            if ((rs & 960) == 0)
                c += 1;
            if ((rs & 240) == 0 && c == 0)
                c = 1;
            ans += c;
        }
        return ans + 2*(n - map.size());
    }
}