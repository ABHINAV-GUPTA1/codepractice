class Solution {
    public long dividePlayers(int[] skill) {
        int sum = 0;
        int[] arr = new int[1001];
        for (int i = 0; i < skill.length; i++) {
            arr[skill[i]]++;
            sum += skill[i];
        }

        int teams = skill.length / 2;
        if (sum%teams != 0) {
            return -1;
        }
        int req = sum / teams;
        long ans = 0;
        for (int i = 0; i < skill.length; i++) {
            int val1 = skill[i];
            int val2 = req - val1;

            if (arr[val2] <= 0) {
                return -1;
            }

            arr[val2]--;
            ans += (val1 * val2);
        }

        return ans / 2;
    }
}