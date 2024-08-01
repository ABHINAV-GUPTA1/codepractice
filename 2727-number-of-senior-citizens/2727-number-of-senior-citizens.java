class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String s : details) {
            count += (Integer.parseInt(s.substring(11, s.length()-2))) > 60 ? 1 : 0;
        }    

        return count;
    }
}