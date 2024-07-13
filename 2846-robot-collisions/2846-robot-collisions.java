class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> idArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            idArr.add(i);
        }
        Collections.sort(idArr, (a,b)->positions[a]-positions[b]);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            int curr = idArr.get(i);
            if (directions.charAt(curr) == 'R') {
                st.push(idArr.get(i));
            } else {
                while (!st.isEmpty() && healths[curr] > 0) {
                    if (healths[st.peek()] > healths[curr]) {
                        healths[curr] = 0;
                        healths[st.peek()] -= 1;
                    } else if (healths[st.peek()] < healths[curr]) {
                        healths[curr]-=1;
                        healths[st.pop()] = 0;
                    } else {
                        healths[curr]=0;
                        healths[st.pop()] = 0;
                    }
                }
            } 
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                res.add(healths[i]);
            }
        }

        return res;
    }
}