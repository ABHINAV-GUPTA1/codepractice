class Solution {
    public String reverseWords(String s) {
        char[] strArr = s.toCharArray();
        reverse(strArr, 0, strArr.length - 1);
        reverseWords(strArr);   
        return removeSpace(strArr); 
    }

    private void reverseWords (char[] arr) {
        int head = 0;
        int length = arr.length;
        int tail = 0;
        while (head < length) {
            
            while (head < tail || head < length && arr[head] == ' ') {
                head++;
            }

            while (tail < head || tail < length && arr[tail] != ' ') {
                tail++;
            }

            reverse(arr, head, tail - 1);
        }
    }

    private String removeSpace(char[] arr) {
        int head = 0, tail = 0;
        int length = arr.length;
        while (head < length) {
            
            while (head < tail || head < length && arr[head] == ' ') {
                head++;
            }
            
            while (head < length && arr[head] != ' ') {
                arr[tail++] = arr[head++];
            }
            
            while (head < length && arr[head] == ' ') {
                head++;
            }
            if (head < length) {
                arr[tail++] = ' ';
            }
        }
        return new String(arr).substring(0, tail);
    }

    private void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
    }
}