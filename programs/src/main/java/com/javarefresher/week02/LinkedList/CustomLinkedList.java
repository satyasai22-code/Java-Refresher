package com.javarefresher.week02.LinkedList;

/**
 * LinkedList
 */
class CustomLinkedList {
    class Node{
        int key;
        Node next;
        public Node(int key){
            this.key = key;
            this.next = null;
        }
    }
    Node head ;
    public CustomLinkedList(){
        this.head = null;
    }

    public void add(int key){
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
    public void delete(int key){
        if(head!=null && head.key == key){
            Node temp = head.next;
            head.next = null;
            head = temp;
            return;
        }
        Node tempHead = head;
        while(tempHead !=null && tempHead.next != null){
            if(tempHead.next.key == key){
                Node temp = tempHead.next.next;
                tempHead.next.next = null;
                tempHead.next = temp;
                break;       
            }
            tempHead = tempHead.next;
        }
    }
}