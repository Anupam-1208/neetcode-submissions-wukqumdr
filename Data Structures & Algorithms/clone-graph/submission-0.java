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

    public Node cloneGraph(Node node) {
        // add curNode to the edge of the parent 
        // if something is visited then revert back 
        // but dont 
        Map<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);

    }
    public Node dfs(Node node, Map<Integer, Node> visited) {
        if (node == null) {
            return null;
        }
        if (visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        Node cloned = new Node(node.val);
        visited.put(node.val, cloned);
        
        for(Node child: node.neighbors) {
            Node clondChild = dfs(child, visited);
            cloned.neighbors.add(clondChild);
        }
        return cloned;
    }
}