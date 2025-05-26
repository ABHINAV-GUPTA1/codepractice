class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int push = -1, pop = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushed[++push] = pushed[i];
            while (push >= 0 && pop < pushed.length && pushed[push] == popped[pop]) {
                push--;
                pop++;
            }
        }

        return pop == popped.length;
    }
}