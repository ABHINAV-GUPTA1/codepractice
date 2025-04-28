class Solution {
    public String addStrings(String num1, String num2) {
        
        StringBuilder sb = new StringBuilder();
        
        int idx1 = num1.length() - 1;
        int idx2 = num2.length() - 1;
        int carry = 0;

        while (idx1 >= 0 || idx2 >= 0 || carry > 0) {
            int val1 = idx1 >= 0 ? num1.charAt(idx1--) - '0' : 0;
            int val2 = idx2 >= 0 ? num2.charAt(idx2--) - '0' : 0;
            int sum = val1 + val2 + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        return sb.reverse().toString();
    }
}