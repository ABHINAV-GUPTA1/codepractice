class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }    
        return Arrays.stream(nums).boxed().sorted((a,b)-> {
            int k1 = map.get(a);
            int k2 = map.get(b);
            if (k1 == k2) {
                return b-a;
            }
            return k1-k2;
        }
        ).mapToInt(Integer::intValue).toArray();
    }
}