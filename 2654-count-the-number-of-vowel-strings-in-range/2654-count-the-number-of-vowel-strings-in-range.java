class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        if (left == right) {
            return checkVowel(words[left].charAt(0)) && checkVowel(words[left].charAt(words[left].length()-1)) ? 1 : 0;
        }    
        if (left > right) {
            return 0;
        }
        int count =  checkVowel(words[left].charAt(0)) && checkVowel(words[left].charAt(words[left].length()-1)) ? 1 : 0;

        count +=  checkVowel(words[right].charAt(0)) && checkVowel(words[right].charAt(words[right].length()-1)) ? 1 : 0;
        return count + vowelStrings(words, left+1, right-1);
    }

    private boolean checkVowel(char a) {
        return (a=='a' || a == 'e' || a == 'i' || a == 'o' || a == 'u'); 
    }
}