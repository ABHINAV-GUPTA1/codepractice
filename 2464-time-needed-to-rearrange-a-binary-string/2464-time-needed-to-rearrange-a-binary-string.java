class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        while (true) {
            boolean flag = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i-1] == '0' && arr[i] == '1') {
                    arr[i-1] = '1';
                    arr[i] = '0';
                    flag = true;
                    i++;
                }
            }
            if (!flag) {
                break;
            }
            count++;
        }    
        return count;
    }
}