package LinkedList;
public class MergeSort {
    public class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public void addfirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addlast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }
    public void print(){
        Node temp = head;
        if(head==null){
            System.out.println("List is Empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data+"->");
            temp  = temp.next;
        }
        System.out.println("null");
    }
    public Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public Node merge(Node head1, Node head2){
        Node merge = new Node(-1);
        Node temp = merge;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1!=null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2!=null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;

        }
        return merge.next;
    }
    public Node mergeSort(Node head){
        if(head == null || head.next==null){
            return head;
        }
        // find mid
        Node mid = getMid(head);
        // left & right mergesort
        Node righthead = mid.next;
        mid.next = null;
       Node newleft =  mergeSort(head);
       Node newright =  mergeSort(righthead);
       return merge(newleft,newright);
    }
    public static void main(String args[]){
        MergeSort list = new MergeSort();
        list.addfirst(1);
        list.addlast(2);
        list.addlast(3);
        list.addfirst(5);
        list.print();
        System.out.println("After sorting");

        list.print();

    }
}
