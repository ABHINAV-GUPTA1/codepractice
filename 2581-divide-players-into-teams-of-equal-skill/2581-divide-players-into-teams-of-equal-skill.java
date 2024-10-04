class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int i = 0;
        int j = skill.length-1;
        long s = skill[i] + skill[j];
        long ans = 0;
        while (i < j) {
            if (skill[i]+skill[j] != s) {
                return -1;
            }
            ans += ((long)skill[i])*skill[j];
            i++;
            j--;
        }

        return ans;
    }
}