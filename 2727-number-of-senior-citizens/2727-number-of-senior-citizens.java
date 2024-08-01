class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        int c1;
        int c2;
        int age;
        for (String s : details) {
            c1 = s.charAt(11) - '0';
            c2 = s.charAt(12) - '0';
            age = c1*10+c2;
            if (age > 60) {
                count++;
            }
        }    

        return count;
    }
}