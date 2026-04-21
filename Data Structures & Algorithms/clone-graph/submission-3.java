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
        mapClones.put(node, new Node(node.val));
        
        Queue<Node> queueNodes = new LinkedList<>();
        queueNodes.add(node);

        while(!queueNodes.isEmpty())
        {
            Node currNode = queueNodes.poll();
            
            for(Node neighbor : currNode.neighbors)
            {
                if(!mapClones.containsKey(neighbor))
                {
                    Node cloneNeighbor = new Node(neighbor.val);
                    mapClones.put(neighbor, cloneNeighbor);
                    queueNodes.add(neighbor);
                }
                mapClones.get(currNode).neighbors.add(mapClones.get(neighbor));
            }
        }

        return mapClones.get(node); 
    }
}








