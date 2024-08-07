class Solution {
    static Map<Integer, String> onesMap = new HashMap<>();
    static Map<Integer, String> tensMap = new HashMap<>();
    static Map<Integer, String> hundredMap = new HashMap<>();
    
    static {
        onesMap.put(0, "");
        onesMap.put(1, "One");
        onesMap.put(2, "Two");
        onesMap.put(3, "Three");
        onesMap.put(4, "Four");
        onesMap.put(5, "Five");
        onesMap.put(6, "Six");
        onesMap.put(7, "Seven");
        onesMap.put(8, "Eight");
        onesMap.put(9, "Nine");


        tensMap.put(10, "Ten");
        tensMap.put(11, "Eleven");
        tensMap.put(12, "Twelve");
        tensMap.put(13, "Thirteen");
        tensMap.put(14, "Fourteen");
        tensMap.put(15, "Fifteen");
        tensMap.put(16, "Sixteen");
        tensMap.put(17, "Seventeen");
        tensMap.put(18, "Eighteen");
        tensMap.put(19, "Nineteen");

        hundredMap.put(1, "Ten");
        hundredMap.put(2, "Twenty");
        hundredMap.put(3, "Thirty");
        hundredMap.put(4, "Forty");
        hundredMap.put(5, "Fifty");
        hundredMap.put(6, "Sixty");
        hundredMap.put(7, "Seventy");
        hundredMap.put(8, "Eighty");
        hundredMap.put(9, "Ninety");
    }
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }

        return solve(num);
    }

    private String solve(int n) {
        if (n < 10) {
            return onesMap.get(n);
        }
        if (n < 20) {
            return tensMap.get(n);
        }
        if (n < 100) {
            return new StringBuilder(hundredMap.get(n/10)).append(n%10 != 0 ? " " : "").append(n%10 != 0 ? onesMap.get(n%10):"").toString();
        }

        if (n < 1000) {
            return new StringBuilder(solve(n/100)).append(" Hundred").append(n%100 != 0 ? " " : "").append(n%100 != 0 ? solve(n%100):"").toString();
        }

        if (n < 10_00_000) {
            return new StringBuilder(solve(n/1000)).append(" Thousand").append(n%1000 != 0 ? " " : "").append(n%1000 != 0 ? solve(n%1000):"").toString();
        }

        if (n < 1_000_000_000) {
            return new StringBuilder(solve(n/10_00_000)).append(" Million").append(n%10_00_000 != 0 ? " " : "").append(n%10_00_000 != 0 ? solve(n%10_00_000):"").toString();
        }

        return new StringBuilder(solve(n/1_000_000_000)).append(" Billion").append(n%1_000_000_000 != 0 ? " " : "").append(n%1_000_000_000 != 0 ? solve(n%1_000_000_000):"").toString();

    }
}