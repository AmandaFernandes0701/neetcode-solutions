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

    private HashMap<Node, Node> mapCopyNodes = new HashMap<>();

    public Node cloneGraph(Node node) {

        HashSet<Node> visitados = new HashSet<>();

        dfsGrafo(node, visitados, true);

        visitados.clear();

        dfsGrafo(node, visitados, false);

        return mapCopyNodes.get(node); 
    }

    public void dfsGrafo(Node currNode, HashSet<Node> visitados, boolean copiando)
    {
        if(currNode == null || visitados.contains(currNode)) return;

        visitados.add(currNode);

        if(copiando) mapCopyNodes.put(currNode, new Node(currNode.val));

        for(Node vizinho : currNode.neighbors)
        {
            if(!copiando) mapCopyNodes.get(currNode).neighbors.add(mapCopyNodes.get(vizinho));
            dfsGrafo(vizinho, visitados, copiando);
        }
    }
}








