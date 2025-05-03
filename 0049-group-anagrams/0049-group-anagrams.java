class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            map.computeIfAbsent(String.valueOf(arr), x->new ArrayList<>()).add(str);
        }

        // List<List<String>> res = new ArrayList<>();
        // for (Map.Entry<String, List<String>> me : map.entrySet()) {
        //     res.add(me.getValue());
        // }
        // return res;
        return map.values().stream().collect(Collectors.toList());
    }
}