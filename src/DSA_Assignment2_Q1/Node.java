package DSA_Assignment2_Q1;

/**
 *
 * @author flynn
 */
public class Node<E extends Comparable> implements Comparable<Node> {
    public E data;
    public Node right;
    public Node left;
    
    public Node(E data){
        this.data = data;
    }
    
    public int compareTo(Node node) {
        return data.compareTo(node.data);
    }
    
}
