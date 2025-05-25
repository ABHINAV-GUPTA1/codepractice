class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0 || res.get(res.size() - 1)[1] < intervals[i][0]){
                res.add(intervals[i]);
            } else {
                int[] tmp = res.get(res.size() - 1);
                tmp[0] = Math.min(tmp[0], intervals[i][0]);
                tmp[1] = Math.max(tmp[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][]);    
    }
}