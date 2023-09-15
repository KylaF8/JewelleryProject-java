package Resources;

import com.thoughtworks.xstream.mapper.Mapper;

//Head of linked list
public class LinkedList<o> {
    private Node head = null;

    private int nodes = 0;

    public Node getHead() {
        return head;
    }


    //Create a new node
    public void addNode(Object data) {
        Node newNode = new Node(data);

        //Checks if list is empty/null
        if(head == null) {
            //If is empty it points to new node to make a new head
            head = newNode;
        }
        else {
            Node temp = new Node(data);  //Temp (temporary) is thing you want to point to
            Node current = head;

            if (current != null) {  //Checks if is null
                while (current.getNext() != null){  //Keeps going until it finds last node and has null next to it
                    current = current.getNext();
                }
                current.setNext(temp);  //Points last node to temp making a new node
            }
        }
        nodes ++;  //Adds to int nodes
    }


    public Object get(int index) {
        if (head != null) {   //Checks if head is not null
            if (index == 0)
                return head.getData();
            Node current = null;   //If index is 0 it returns head and makes current null

            current = head.getNext();   //If index more than 0, sets current to the node after head
            for (int i = 1; i < index; i++) {   //Does a for loop through the index
                if (current.getNext() == null)
                    return null;   //Keeps going through the index til next points to null
                current = current.getNext();
            }
            return current.getData();    //Returns get data for each index
        }
        else{
            return null;
        }
    }

    public void deleteAll (){ //If head is not null it makes it null
        if (head != null){
            head = null;
        }
    }

    //Returns number of nodes in linked lists
    public int listSize(){
        return nodes;
    }







}
