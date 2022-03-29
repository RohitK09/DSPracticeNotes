class Trie {
    private Trie[] links;
    private final int R = 26; 
    private boolean isEnd; 
    
    public Trie() {
        root = new Trie[R];
    }
    
    public boolean containsChar(char ch) {
        return links[ch-'a'] != null; 
    }
    
    public Trie put(char ch, Trie node) {
        return links[ch-'a'] = node;
    }
    
    public Trie get(char ch) {
        return links[ch-'a'];
    }
    
    public void setEnd() {
        this.isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
    
    public void insert(String word) {
        Trie node = root;
        for(char curr: word.toCharArray()) {
            if(!node.contains(curr)) {
                node.put(curr, node);
            } 
            node = node.get(curr); //start from the next char in trie node.
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Trie node = root;
        for(char curr: word.toCharArray()) {
            if(!node.contains(curr)) {
                return false;
            } 
            node = node.get(curr); //start from the next char in trie node.
        }
        
        if(!node.isEnd) {
            return false;
        }
        return true;
    }
    
    public boolean startsWith(String prefix) {
        Trie node = root;
        for(char curr: word.toCharArray()) {
            if(!node.contains(curr)) {
                return false;
            } 
            node = node.get(curr); //start from the next char in trie node.
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */