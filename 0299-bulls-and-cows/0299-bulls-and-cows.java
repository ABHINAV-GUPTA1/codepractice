class Solution {
    public String getHint(String secret, String guess) {
        int bullCount = 0, cowCount = 0;
        Set<Integer> bullSet = new HashSet<>();
        int[] cowMap = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
                bullSet.add(i);
            } else {
                cowMap[guess.charAt(i) - '0']++;
            }
        }

        for (int i = 0; i < secret.length(); i++) {
            if (!bullSet.contains(i) && cowMap[secret.charAt(i) - '0'] > 0) {
                //secret.charAt(i) != guess.charAt(i)) {
                cowCount++;
                cowMap[secret.charAt(i) - '0']--;
            } 
        }
        return new StringBuilder().append(bullCount).append("A").append(cowCount).append("B").toString();
    }
}