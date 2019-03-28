import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int n){
        this.data = n;
        this.next = null;
    }
    
    public void setNext(Node n2){
        this.next = n2;
    }
    
    public boolean hasNext(){
        if (this.next != null){
            return true;
        } else {
            return false;
        }
    }
    
    public void printNode(){
        System.out.print(this.data);
    }
    
    public static void main(String[] args){
        Node n = new Node(4);
        System.out.println("Congrats! You've created a node with value: ");
        n.printNode();
    }
    
}
