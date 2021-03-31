package implementation.trie;

public class Trie {
    private final TrieNode root;

    private static class TrieNode {
        private final char val;
        private final TrieNode[] children;
        private boolean isWord;

        public TrieNode(char val) {
            this.val = val;
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode cur = this.root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                cur.children[idx] = new TrieNode(ch);
            }
            cur = cur.children[idx];
        }
        cur.isWord = true; // mark the termination of work path
    }

    public boolean search(String word) {
        TrieNode end = searchByPrefix(word);
        return end != null && end.isWord; // check whether is a valid end of word path
    }

    public boolean startWith(String prefix) {
        TrieNode end = searchByPrefix(prefix);
        return end != null;
    }

    public TrieNode searchByPrefix(String prefix) {
        TrieNode cur = this.root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (cur.children[idx] == null) {
                return null;
            }
            cur = cur.children[idx];
        }
        return cur; // check whether is a valid end of word path
    }
}
