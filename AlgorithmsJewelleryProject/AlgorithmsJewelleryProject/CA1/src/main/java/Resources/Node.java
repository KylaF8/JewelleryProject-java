package Resources;

public class Node {

        Object data;

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //Creates a node
    Node next;

        //Constructor
        Node(Object d)
        {
            data = d;
            next = null;
        }

}
