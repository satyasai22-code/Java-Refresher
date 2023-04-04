package com.javarefresher.week02.LinkedList02;

/**
 * LinkedList
 */
class CustomLinkedList<E> {
    class Node{
        E key;
        Node next;
        public Node(E key){
            this.key = key;
            this.next = null;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node that = (Node) o;
            return key.equals(that.key);
        }
    }
    Node head ;
    public CustomLinkedList(){
        this.head = null;
    }

    public void add(E key){
        Node temp = new Node(key);  
        if(head == null){
            head = temp;
            return;
        }
        Node tempHead = head;
        while(tempHead.next != null){
            tempHead = tempHead.next;
        }        
        tempHead.next = temp;
    }
    public void printAll(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void delete(E key){
        if(head!=null && head.key.equals(key)){
            Node temp = head.next;
            head.next = null;
            head = temp;
            return;
        }
        Node tempHead = head;
        while(tempHead !=null && tempHead.next != null){
            if(tempHead.next.key.equals(key)){
                Node temp = tempHead.next.next;
                tempHead.next.next = null;
                tempHead.next = temp;
                break;       
            }
            tempHead = tempHead.next;
        }
    }
}