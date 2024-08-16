class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size(); i++) {
            res = Math.max(Math.abs(arrays.get(i).get(arrays.get(i).size()-1) - min), res);
            res = Math.max(max - arrays.get(i).get(0), res);

            min = Math.min(arrays.get(i).get(0), min);
            max = Math.max(arrays.get(i).get(arrays.get(i).size()-1), max);
        }

        return res;
    }
}