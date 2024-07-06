class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char c[] = strs[i].toCharArray();
            Arrays.sort(c);
            map.computeIfAbsent(new String(c), x->new ArrayList<>()).add(strs[i]);
        }

        return map.values().stream().collect(Collectors.toList());
    }
}