/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Map<Node, Node> oldToNew = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if (node == null) {return null;}
        return cloneGraphHelper(node);
    }
    public Node cloneGraphHelper(Node oldNode) {
        if(oldToNew.containsKey(oldNode)){
            return oldToNew.get(oldNode);
        }
        Node clonedNode = new Node(oldNode.val);
        oldToNew.put(oldNode, clonedNode);
        for(Node neighbor: oldNode.neighbors){
            Node clonedNeighbor = cloneGraphHelper(neighbor);
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }
}