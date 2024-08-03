class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // Map<Integer, Integer> freq = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        //     freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        // }        
        // for (int i = 0; i < target.length; i++) {
        //     if (!freq.containsKey(target[i])) {
        //         return false;
        //     }
        //     freq.put(target[i], freq.get(target[i]) - 1);
        //     if (freq.get(target[i]) == 0) {
        //         freq.remove(target[i]);
        //     }
        // }

        // return freq.isEmpty();

        Arrays.sort(arr);
        Arrays.sort(target);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != target[i]) {
                return false;
            }
        }
        return true;
    }
}