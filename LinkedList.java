public class LinkedList implements  List {
    public Node head;
    public int length;

    public LinkedList(){
        this.head = null;
        this.length = 0;
    }

//////////////////////////////////////////////////////
    public class Node {
        Object data;
        Node next;

        public Node(){ //empty constructor with default values
            this.data = 0;
            this.next = null;
        }

        public Node(Object obj){ //constructor that initializes the given data
            this.data = obj;
            this.next = null;
        }

        public Object getData() { //returns the value of the node
            return data;
        }

        public void setData(int data) { //sets the value of the current node
            this.data = data;
        }

        public Node getNext() {//returns the pointer of the current node
            return next;
        }

        public void setNext(Node next) { //sets the pointer of the current node to the given node
            this.next = next;
        }
    }
//////////////////////////////////////////////////////

    @Override
    public void add(int pos, Object obj) {
        Node newNode = new Node(obj);

        if(pos == 0){
            if(length == 0) {
                head = newNode;
                length++;
                return;
            }
            else{
                newNode.setNext(head);
                head = newNode;
                return;
            }
        }
        else if(pos > length){
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }

        Node temp = head;
        for(int i = 0; i < pos-1; i++){
            temp = temp.getNext();
        }

        newNode.setNext(temp.getNext());
        temp.setNext(newNode);
        length++;
    }

    @Override
    public void add(Object obj) {
        Node temp = head;
        Node newNode = new Node(obj);
        if(length == 0) {
            head = newNode;
            length++;
            return;
        }

        while(temp.getNext() != null){
            temp = temp.getNext();
        }
        temp.setNext(newNode);
        length++;
    }

    @Override
    public Object remove(int pos) {
        if(pos >= length){
            System.out.println("Index Out of Bounds");
            return null;
        }

        Node temp = head;
        Node previous = head;

        for(int i = 0; i < pos; i++){
            previous = temp;
            temp = temp.getNext();
        }

        previous.setNext(temp.getNext());

        length--;

        return temp.getData();
    }

    @Override
    public Object get(int pos) {
        if(pos >= length){
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }

        Node temp = head;
        for(int i = 0; i < pos; i++){
            temp = temp.getNext();
        }

        return temp.getData();
    }

    @Override
    public int size() {
        return length;
    }
}
