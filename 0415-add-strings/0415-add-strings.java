class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        int v1, v2;
        while (i >= 0 || j >= 0) {
            v1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            v2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = v1+v2+carry;
            carry = sum / 10;
            sb.insert(0, (sum%10));

            i--;
            j--;
        }    
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
}