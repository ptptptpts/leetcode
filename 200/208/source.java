class Trie {
    private final TrieNode mFirstCharacter = new TrieNode();

    public Trie() {
    }

    public void insert(String word) {
        TrieNode node = mFirstCharacter;

        for (char c : word.toCharArray()) {
            int pos = c - 'a';

            if (node.children[pos] == null) {
                TrieNode newNode = new TrieNode();
                node.children[pos] = newNode;
            }

            node = node.children[pos];
        }

        node.isValid = true;
    }

    public boolean search(String word) {
        TrieNode node = findFromTrie(word);

        if (node == null) {
            return false;
        } else {
            return node.isValid;
        }
    }

    public boolean startsWith(String prefix) {
        return findFromTrie(prefix) != null;
    }

    private TrieNode findFromTrie(String word) {
        TrieNode node = mFirstCharacter;

        for (char c : word.toCharArray()) {
            int pos = c - 'a';

            if (node.children[pos] == null) {
                node = null;
                break;
            } else {
                node = node.children[pos];
            }
        }
        return node;
    }

    private static class TrieNode {
        boolean isValid = false;
        TrieNode[] children = new TrieNode[26];
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */