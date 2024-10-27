class Trie {
    boolean folder = false;
    Map<String, Trie> child;
    Trie() {
        child = new HashMap<>();
    }

}
class Solution {
    
    List<String> res;

    public void insert(Trie root, String s) {
        Trie t = root;
        String str[] = s.split("/");
        if (str.length < 1) {
            return;
        }
        if (str.length < 2 && str[0].trim().isEmpty()) {
            return;
        }
        if (!t.child.containsKey("/")) {
            t.child.put("/", new Trie());
        }
        t = t.child.get("/");
        for (int i = 1; i < str.length; i++) {
            if (t.folder) {
                return;
            }
            if (!t.child.containsKey(str[i])) {
                t.child.put(str[i], new Trie());
            }
            t = t.child.get(str[i]);
        }
        res.add(s);
        t.folder = true;
    }

    public List<String> removeSubfolders(String[] folder) {
        res = new ArrayList<>();
        Trie root = new Trie();
        Arrays.sort(folder);
        for (int i = 0; i < folder.length; i++) {
            insert(root, folder[i]);
        }
        return res;
    }
}