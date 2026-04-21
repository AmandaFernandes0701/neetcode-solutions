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

        criaCopiosDosNos(node, visitados);

        visitados.clear();

        fazLigacaoDosNos(node, visitados);

        return mapCopyNodes.get(node); 
    }

    public void criaCopiosDosNos(Node currNode, HashSet<Node> visitados)
    {
        if(currNode == null || visitados.contains(currNode)) return;

        visitados.add(currNode);

        mapCopyNodes.put(currNode, new Node(currNode.val));

        System.out.println("Nó visitado: " + currNode.val);

        for(Node vizinho : currNode.neighbors)
            criaCopiosDosNos(vizinho, visitados);
    }

    public void fazLigacaoDosNos(Node currNode, HashSet<Node> visitados)
    {
        if(currNode == null || visitados.contains(currNode)) return;

        visitados.add(currNode);

        for(Node vizinho : currNode.neighbors)
        {
            mapCopyNodes.get(currNode).neighbors.add(mapCopyNodes.get(vizinho));
            fazLigacaoDosNos(vizinho, visitados);
        }
    }
}








