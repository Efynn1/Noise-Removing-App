package DSA_Assignment2_Q1;

/**
 *
 * @author flynn
 */
public class BinaryTree<E extends Comparable> {
    //initialise root and size of tree
    Node<E> root;
    int size = 0;
    
    public BinaryTree(){
        root = null;
    }
    
    //sets the binary tree to take in value as its root node
    public BinaryTree(E value) {
        root = new Node(value);
    }
    
    //adds object to tree
    void add(E data) {
        //recursively traverse tree till added in correct order
        root = addRecursively(root, data);
        size += 1;
    }
    
    public Node addRecursively(Node root, E data) {
        //return new node if tree is empty
        if(root == null) {
            root = new Node(data);
            return root;
        }
        //else traverse down to find correct spot in tree
        else if(data.compareTo(root.data)<0) {
            root.left = addRecursively(root.left, data);
        } else if(data.compareTo(root.data)>0) {
            root.right = addRecursively(root.right, data);
        }
        return root;
    }
    
    public void findNode(E data) {
        //set temporary node to compare till data is found/not found
        Node temp = findNodeutil(root, data);
        if(temp != null) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
    
    public Node findNodeutil(Node root, E data) {
        //Return if root = data or root is empty and therefore data is not in tree anyway
        if (root == null || data.compareTo(root.data)==0) {
            return root;
        }
        if (data.compareTo(root.data)<0) {
            return findNodeutil(root.left, data);
        }
        
        return findNodeutil(root.right, data);
    }
    
    public void traversal() {
        //calls recursive traversal
        traversalRecursively(root);
        System.out.println("");
    }
    
    public void traversalRecursively(Node root){
        if (root != null){
            traversalRecursively(root.left);
            System.out.println(root.data);
            traversalRecursively(root.right);
        }
    }
    
    public void reverseOrder() {
        reverseOrderRecursively(root);
    }
    
    public void reverseOrderRecursively(Node root) {
        //traverse tree in reverse
        if (root != null) {
            reverseOrderRecursively(root.right);
            System.out.println(root.data);
            reverseOrderRecursively(root.left);
        }
    }
}
    
    


