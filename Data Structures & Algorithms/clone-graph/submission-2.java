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

    private HashMap<Node, Node> mapClones;

    public Node cloneGraph(Node node) {
        
        if(node == null) return null;

        mapClones = new HashMap<>();
        return cloneGraphDFS(node); 
    }

    private Node cloneGraphDFS(Node currNode)
    {
        if(mapClones.containsKey(currNode))
            return mapClones.get(currNode);
        
        Node currClone = new Node(currNode.val);
        mapClones.put(currNode, currClone);

        for(Node neighbor : currNode.neighbors)
        {
            Node cloneNeighbor = cloneGraphDFS(neighbor);
            currClone.neighbors.add(cloneNeighbor);
        }

        return currClone;
    }
}








