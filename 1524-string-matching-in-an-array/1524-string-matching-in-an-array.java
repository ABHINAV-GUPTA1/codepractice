class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> matchingWords = new ArrayList<>();

        for (
            int currentWordIndex = 0;
            currentWordIndex < words.length;
            currentWordIndex++
        ) {
            int[] lps = computeLPSArray(words[currentWordIndex]);
            for (
                int otherWordIndex = 0;
                otherWordIndex < words.length;
                otherWordIndex++
            ) {
                if (currentWordIndex == otherWordIndex)
                    continue; 

                if (
                    isSubstringOf(
                        words[currentWordIndex],
                        words[otherWordIndex],
                        lps
                    )
                ) {
                    matchingWords.add(words[currentWordIndex]);
                    break; 
                }
            }
        }

        return matchingWords;
    }

    private int[] computeLPSArray(String sub) {
        int[] lps = new int[sub.length()];
        int currentIndex = 1;
        int len = 0;

        while (currentIndex < sub.length()) {
            if (sub.charAt(currentIndex) == sub.charAt(len)) {
                len++;
                lps[currentIndex] = len;
                currentIndex++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    currentIndex++;
                }
            }
        }
        return lps;
    }

    private boolean isSubstringOf(String sub, String main, int[] lps) {
        int mainIndex = 0;
        int subIndex = 0;

        while (mainIndex < main.length()) {
            if (main.charAt(mainIndex) == sub.charAt(subIndex)) {
                mainIndex++;
                subIndex++;
                if (subIndex == sub.length()) return true; 
            } else {
                if (subIndex > 0) {
                    subIndex = lps[subIndex - 1]; 
                } else {
                    mainIndex++;
                }
            }
        }
        return false; 
    }
}