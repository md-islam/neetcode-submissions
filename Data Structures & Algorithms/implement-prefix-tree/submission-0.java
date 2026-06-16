class PrefixTree {

    class TrieNode{
        boolean isWord;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
         root.isWord = false;
         root.children = new HashMap<Character, TrieNode>();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(Character c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(Character c: word.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(Character c: prefix.toCharArray()){
            if(!current.children.containsKey(c)){
                return false;
            } else {
                current = current.children.get(c);
            }
        }
        return true;
    }
}
