/*
// Definition for a Node.
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
       
       if(node == null) return null;
   
       Node visited[] = new Node[105]; 
       
       Node copiedNode = new Node(node.val);

       
       Queue<Node> q = new LinkedList<>();
       q.add(node);

       visited[copiedNode.val] = copiedNode;

       while(!q.isEmpty()){

           Node popOrig = q.poll();
           
           for(Node n:popOrig.neighbors){
               if(visited[n.val] == null){
                   visited[n.val] = new Node(n.val);
                   q.add(n);
               }
               visited[popOrig.val].neighbors.add(visited[n.val]);
               
           }
       }

       return copiedNode;

       
   }
}