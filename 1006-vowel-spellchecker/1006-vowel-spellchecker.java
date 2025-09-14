class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> vowelMap = new HashMap<>();
        Map<String, String> capsMap = new HashMap<>();
        String[] ans = new String[queries.length];
        for (String word : wordlist) {
            String lower = word.toLowerCase();
            String vowelRemovedStr = getVowelRemovedStr(lower);
            capsMap.putIfAbsent(lower, word);
            vowelMap.putIfAbsent(vowelRemovedStr, word);
        }

        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) {
                ans[i] = queries[i];
                continue;
            }
            String lower = queries[i].toLowerCase();
            if (capsMap.containsKey(lower)) {
                ans[i] = capsMap.get(lower);
            } else {
                String vowelRemovedStr = getVowelRemovedStr(lower);
                if (vowelMap.containsKey(vowelRemovedStr)) {
                    ans[i] = vowelMap.get(vowelRemovedStr);
                } else {
                    ans[i] = "";
                }
            }
        }

        return ans;
    }

    private String getVowelRemovedStr(String str) {
        return str.replaceAll("[aeiou]", "#");
    }

}