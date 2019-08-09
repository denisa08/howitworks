package algobootcamp.sq;

import java.util.EmptyStackException;


//lifo. LastInFirstOut
public class Stack {
         private Node head;

        private class Node{
            int data;
            private Node next;
            private Node (int data){this.data=data;}
        }


        private boolean isEmpty(){
            return head==null;
        }

        public int peek(){
            return head.data;
        }

        //store new data
        public void push(int data){
            Node newNode = new Node(data);
            newNode.next=head;
            head=newNode;
        }

        //get stack data

        public int pop(){
            if (head==null) throw new EmptyStackException();
            int data=head.data;
            head=head.next;
            return data;
         }








}
