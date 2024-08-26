class Solution {
    public String fractionAddition(String expression) {
        int currNum = 0;
        int currDenom = 0;
        int num = 0;
        int denom = 1;
        boolean isNeg = false;
        int n = expression.length();
        boolean isNum = true;
        int i = 0; 
        while (i <  n) {
            isNeg = expression.charAt(i) == '-';
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                i++;
            }
            currNum = 0;
            currDenom = 0;
            while (i < n && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                currNum = currNum*10 + (expression.charAt(i)-'0');
                i++;
            }
            if (isNeg) {
                currNum = -currNum;
            }
            i++; // for divide / symbol
            while (i < n && expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                currDenom = currDenom*10 + (expression.charAt(i)-'0');
                i++;
            }

            num = num*currDenom + currNum*denom;
            denom = currDenom * denom;
        }
        
        int gcd = gcd(Math.abs(num), denom);
        num = num/gcd;
        denom = denom / gcd;

        StringBuilder sb = new StringBuilder();
        sb.append(num).append("/").append(denom);
        return sb.toString();
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a%b);
    }
}