import java.util.*;

// Singly linked list library written in Java
// Author: Marisa Pugliese

class LinkedList {
    Node head;
    
    // Constructor, given an int (data) the head of the LinkedList
    public LinkedList(int n){
        Node node = new Node(n);
        this.head = node;
    }
    
    // checkForCycles
    // Returns true if a cycle is find in the LinkedList, and false otherwise
    public boolean checkForCycles(){
        List<Integer> hashCodes = new ArrayList<Integer>();
        Node temp = this.head;
        while (temp.next != null){
            if (hashCodes.contains(temp.hashCode())){
                return true;
            }
            else {
                hashCodes.add(temp.hashCode());
            }
            temp = temp.next;
        }
        return false;
    }
    
    // getLength
    public int getLength() throws Exception{
        if (this.checkForCycles()){
            System.out.println("WARNING!! This LinkedList contains a cycle.");
            throw new Exception();
        }
        Node temp = this.head;
        int count = 0;
        while (temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    // pushNode
    // Add any already created node to the end of the LinkedList
    public void pushNode(Node n){
        Node temp = this.head;
        while(temp.hasNext()){
            temp = temp.next;
        }
        temp.setNext(n);
    }
    
    // push
    // Given an integer, create a node with data n and insert it at the end of the list
    public void push(int n){
        Node node = new Node(n);
        Node temp = this.head;
        while(temp.hasNext()){
            temp = temp.next;
        }
        temp.setNext(node);
    }
    
    // Pop
    // Removes the last element of the LinkedList
    public void pop(){
        System.out.println("Popping the last element of the list...");
        Node temp = this.head;
        // Traverse until we reach the second to last node
        while (temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
    }
    
    // removeAtK
    // Removes the node at the kth position
    public void removeAtK(int k) {
        int length;
        try {
            length = this.getLength();
        }
        catch (Exception e){
            System.out.println("Sorry! A cycle was detected in this LinkedList, so we cannot perform this operation.");
            return;
        }
        if ((k > length - 1) || (k < 0)){
            System.out.println("Sorry, invalid K! The length of the list is currently " + length);
        }
        else {
            System.out.println("Removing the node at index " + k + "...");
            Node root = this.head;
            // Traverse until we reach the k-1'st node
            for (int i = 0; i < k - 1; i++){
                root = root.next;
            }
            root.next = root.next.next;
        }
    }
    
    // insertAtK
    // Insert a new node with data n in the list as the kth node
    public void insertAtK(int k, int n) {
        int length;
        try {
            length = this.getLength();
        }
        catch (Exception e){
            System.out.println("Sorry! A cycle was detected in this LinkedList, so we cannot perform this operation.");
            return;
        }
        if ((k > length - 1) || (k < 0)){
            System.out.println("Sorry, invalid K! The length of the list is currently " + length);
        }
        else {
            System.out.println("Inserting a node with a value of " + n + " at index " + k + "...");
            Node root = this.head;
            Node kNode = new Node(n);
            if (k == 0){
                System.out.println("Here we go!");
                kNode.next = root;
                this.head = kNode;
            }
            else { // Traverse until we reach the k-1'st node
                for (int i = 0; i < k - 1; i++){
                    root = root.next;
                }
                Node temp = root.next;
                root.next = kNode;
                kNode.next = temp;
            }
        }
    }
    
    // printList
    public void printList(){
        System.out.println("Here's the list!");
        Node temp = this.head;
        while (temp.next != null){
            temp.printNode();
            System.out.print("=>");
            temp = temp.next;
        }
        temp.printNode();
    }
    
    // Main
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hi, welcome to Marisa's LinkedList demo!");
        System.out.println("Enter any integer to create the head of your very own LinkedList.");
        int head = Integer.parseInt(scanner.nextLine());
        LinkedList userLL = new LinkedList(head);
        System.out.println("Great work!");
        userLL.printList();
        System.out.println();
        System.out.println("Enter another integer to add to your list.");
        int next = Integer.parseInt(scanner.nextLine());
        userLL.push(next);
        System.out.println("One more!");
        next = Integer.parseInt(scanner.nextLine());
        userLL.push(next);
        System.out.println("Awesome!");
        userLL.printList();
        System.out.println();
        System.out.println("Now I will add some random values to your list...");
        Random r = new Random();
        for (int i = 0; i < 7; i++){
            int myInt = r.nextInt(20);
            userLL.push(myInt);
        }
        userLL.printList();
        System.out.println();
        System.out.println("Let's perform some operations on our list.");
        boolean flag = true;
        while (flag){
            System.out.println("Enter one of: pop, push, insert, or remove. Type any key to exit.");
            String op = scanner.nextLine();
            if (op.equals("pop")){
                System.out.println("Let's pop the last element from the LinkedList.");
                userLL.pop();
                userLL.printList();
                System.out.println();
            }
            else if (op.equals("push")){
                System.out.println("Let's push an element to the end of the LinkedList. What value should our node have?");
                int x = Integer.parseInt(scanner.nextLine());
                userLL.push(x);
                userLL.printList();
                System.out.println();
            }
            else if (op.equals("insert")){
                System.out.println("Let's insert an element at a certain position k. First, what value should our node have?");
                int value = Integer.parseInt(scanner.nextLine());
                System.out.println("Cool! At what index should we insert the node? Keep in mind indexing starts at 0.");
                int ind = Integer.parseInt(scanner.nextLine());
                userLL.insertAtK(ind, value);
                userLL.printList();
                System.out.println();
            }
            else if (op.equals("remove")){
                System.out.println("Let's remove an element at a certain position in the list. What index do you choose? Keep in mind indexing starts at 0.");
                int index = Integer.parseInt(scanner.nextLine());
                userLL.removeAtK(index);
                userLL.printList();
                System.out.println();
            }
            else {
                flag = false;
            }
        }
        System.out.println("Thanks for playing! See ya later!");
    }
    
}
