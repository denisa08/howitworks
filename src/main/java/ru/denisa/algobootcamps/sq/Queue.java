package algobootcamp.sq;

public class Queue {
    //remove things here
    private Node head;
    //add thigs here
    private Node tail;


    private class Node{
        private int data;
        private  Node next;
        private Node (int data){this.data=data;}
    }



    public void add(int data){
        //create a new node
        //set the current tail.next to point to this new node
        //then set the new node to be the new tail

        Node newNode =new Node(data);
        if (tail!=null){
            tail.next=newNode;
         }

        tail=newNode;

        //handle case of first element where head is null
        if (head==null){
            head=tail;
        }






    }







}
