class Node {
    private Node nodes[];
    private boolean word;

    public Node() {
        this.nodes = new Node[26];
    }
}

class PrefixTree {

    private Node root;

    public PrefixTree() {
        this.root = new Node();
    }

    public Node helper(char[] arr, boolean create) {
        Node curr = this.root;
        for (char c: arr) {
            int i = c - 'a';

            if (curr.nodes[i] == null) {
                if (create) {
                    curr.nodes[i] = new Node();
                } else {
                    return null;
                }
            }
            curr = curr.nodes[i];
        }
        return curr;
    }

    public void insert(String word) {
        helper(word.toCharArray(), true).word = true;
    }

    public boolean search(String word) {
        return helper(word.toCharArray(), false).word == true;
    }

    public boolean startsWith(String prefix) {
        return helper(prefix.toCharArray(), false) != null;
    }
}
