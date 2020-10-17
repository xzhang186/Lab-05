public class LinkedList<E>{
    Node<E> head;
    int size;
    public class Node<E>{
        E data;
        Node<E> next;

        public Node (E value){
            data=value;
            next=null;
        }
    }
    //constructor
    public LinkedList(){
        head=null;
        size=0;
    }
    //add item to container
    public void add(E item){
        //if empty list, add to head
        if(head==null){
            head= new Node<E>(item);
            ++size;
        }else{
            Node <E>prev= head;
            while(prev.next!= null){
                //create a new Node with item
                prev=prev.next;
            }
            //new node to list and increment size
            Node<E> node = new Node<E>(item);
            prev.next= node;
            ++size;
        }
    }
    //add item by given position
    public void add(E item, int position){
        //if position is zero add to head
        if(position==0){
            Node<E>node= new Node<E>(item);
            node.next= head;
            head=node;
            ++size;
        }else{
            Node<E> prev= head;
            for(int i=0; i<position-1; i++){
                prev = prev.next;
            }
            //add elements to given position, increment size
            Node<E> node= new Node<E>(item);
            node.next=prev.next;
            prev.next=node;
            ++size;
        }
    }
    //get item by given position
    public E get(int position){
        Node<E> curr= head;
        for(int i=0; i<position;i++){
            curr=curr.next;
        }
        return curr.data;
    }
    //remove item by given position
    public E remove(int position){
        //if position is zero, remove item from head
        if(position==0){
            Node<E> node=head;
            head= head.next;
            --size;
            return node.data;
        }else{
            Node<E> prev=head;
            for(int i=0; i<position-1;i++){
                prev=prev.next;
            }
            //change prev.next and decrement size
            Node<E>node=prev.next;
            prev.next=node.next;
            --size;
            return node.data;
        }
    }
    //reverse items
    public Node<E> reverse(Node<E> head){
        Node<E> prev=null;
        Node<E> curr= head;
        Node<E> next= null;
        while(curr!=null){
            next= curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
    //print linked list
    public void printList(){
        Node<E> node= head;
        while(node!=null){
            System.out.print(node.data+"->");
            node=node.next;
        }
    }
    //main
    public static void main(String [] args){
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Given List:");
        list.printList();

        list.add(6);
        System.out.println("\nList after add:");
        list.printList();

        list.add(7,4);
        System.out.println("\nList after add on specific position:");
        list.printList();

        System.out.println("\nNumber get:\n" + list.get(2));

        list.remove(3);
        System.out.println("List after remove:");
        list.printList();

        list.head = list.reverse(list.head);
        System.out.println("\nReversed List:");
        list.printList();
    }
}