package algobootcamp.arrays;

//what different liked list?
//no indexes
// no capacity

//disadvantage : no random access, get/set is linear or O(n)
//advatage: fast insert/delete O(1), can grow incrementaly


public class LinkedList {

    private Node head;

    public void addFront(int data) {

        //create new node
        Node newNode = new Node(data);

        //if it first node, then create head
        if (head == null) {
            head = newNode;
            return ;
        }

        //Set it's next to current head
        newNode.next = head;

        //set current head be the new head
        head = newNode;
    }


    public void addBack(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return ;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }



    public void delete(int value){

         if (head == null) {
            return  ;
        }
         if (head.data==value){
             head=head.next;
             return ;
         }


         Node current = head;
         while (current.next != null) {
            if (current.next.data==value){
                current.next=current.next.next;
                return;

            }
             current = current.next;
         }



    }




    public void clear(){
        head=null;
    }

    public int size() {
        int size = 0;
        if (head == null) {
            return size;
        }
        size=1;
        Node current = head;
        while (current.next != null) {
            current = current.next;
            size++;
        }
         return size;
    }


    public int getFirst() {
        return head.data;
    }


    public int getLast() {
        if (head == null) {
            throw new IllegalStateException("Empty list!");
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        return current.data;
    }


    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


}
