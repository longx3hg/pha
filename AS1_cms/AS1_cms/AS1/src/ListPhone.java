
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListPhone {

    Node head, tail;

    public ListPhone() {
        head = null;
    }

//    private class Node {
//
//        Phone data;
//        Node next;
//
//        Node(Phone x) {
//            data = x;
//            next = null;
//        }
//    }
    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = null;
    }

    String f0_information() {
        //Assign your RollNumber
        String RollNumber = "";
        System.out.println(RollNumber);
        return RollNumber;
    }

    private boolean shouldAdd(Phone x) {
        return !x.type.equals("Op") && x.price <= 40;
    }

    void f1_addHead(Phone x) {
        if (shouldAdd(x)) {
            Node newNode = new Node(x);
            newNode.next = head;
            head = newNode;
            //update tail
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            tail = current; // if next node of current node is null then current node is last node
        }
    }

    void f2_addtail(Phone x) {
        if (shouldAdd(x)) {
            Node newNode = new Node(x);
            if (head == null) {
                head = newNode;
            } else {
                Node current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
                tail = newNode; //update tail
            }
        }
    }

    Node f3_InsertBefore() {
        Phone x = new Phone("Iphone", "X", 0);
        Node newNode = new Node(x);

        if (head == null) {
            //insert x before first Phone has max price.
            return null;
        }

        Node maxPrev = null;
        Node maxNode = head;
        Node current = head;
        double maxPrice = head.inf.price;
        ArrayList<Integer> maxIndex = new ArrayList<>(); //store index of node that has max price
        int nodeIndex = 1;
        //traverse the list to find the node has max price
        while (current.next != null) {
            if (current.next.inf.price > maxPrice) {
                maxPrice = current.next.inf.price;
                maxPrev = current;
                maxNode = current.next;
                nodeIndex += 1;
            }
            current = current.next;
        }
        //last operation will 
        //if there's only one node
        if (maxPrev == null) {
            newNode.next = head;
            head = newNode;
        } else {
            newNode.next = maxNode;
            maxPrev.next = newNode;
        }
        //update tail
        Node traverse = head;
        while (traverse.next != null) {
            traverse = traverse.next;
        }
        tail = traverse;
        return head;
    }

    Node f4_InsertAfter() {
        //insert x after last Phone has max price.        
        Phone x = new Phone("Iphone", "X", 0);
        return null;
    }

    Node f5_removeOne() {
        //remove first Phone has price <20

        //if list is empty return null
        if (isEmpty()) {

        } else if (head.next == null && head.inf.price < 20) {
            //if there's only one node and its price smaller than 20
            head = null;
            return head;
        } else if (head.inf.price < 20) {
            // if head price < 20 remove it and finish
            head = head.next;
            return head;
        } else {
            // if head > 20 start from 2nd node
            Node current = head.next;
            Node previous = head;
            //traverser the queue
            while (current != null) {
                // if current node's price < 20, remove it
                if (current.inf.price < 20) {
                    previous.next = current.next; //skip to next node of current node
                }
                return head; // finish when we found the first node < 20
            }
        }
        return null;
    }

    Node f6_removeAll() {
        //remove all Phones have price <20
        //if list is empty return null
        if (isEmpty()) {

        } else if (head.next == null && head.inf.price < 20) {
            //if there's only one node and its price smaller than 20
            head = null;
            return head;
        } else if (head.inf.price < 20) {
            // if head price < 20 remove it and finish
            head = head.next;
            return head;
        } else {
            // if head > 20 start from 2nd node
            Node current = head.next;
            Node previous = head;
            //traverser the queue
            while (current != null) {
                // if current node's price < 20, remove it
                if (current.inf.price < 20) {
                    previous.next = current.next; //skip to next node of current node
                    current = previous.next; // incrementing node
                } else {
                    //if current node > 20 we move forward
                    previous = current;
                    current = current.next;
                }
            }
            return head;
        }
        return null;
    }

    Node f7_Sort1() {
        //sort list ascending by price
        //pop the maxPri
        if (isEmpty()) {
            return null;
        }
        try {
            Node temp = new Node(front());
            dequeue();
            pushInQueue(temp, getSize());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    /**
     * get size of the queue
     *
     * @return size
     */
    int getSize() {
        if (isEmpty()) {
            return 0;
        } else if (head.next == null) {
            return 1;
        } else {
            Node current = head;
            int count = 1;
            while (current != null) {
                count += 1;
                current = current.next;
            }
            return count;
        }
    }

    /**
     * push an element in the queue while maintaining the sorted order
     *
     * @param temp temporary node
     * @param qsize size of queue
     */
    void pushInQueue(Node temp, int qsize) {
        if (isEmpty()) {
            head = temp;
        } else {
            try {
                //if current element is less than the element at the front
                if (temp.inf.price <= front().price) {
                    //call stack with front queue
                    enqueue(temp.inf);
                    //recursive call for inserting a front node of the queue
                    //to the last
                    FrontToLast(qsize);
                } else {
                    //push front node into last in queue
                    enqueue(front());
                    dequeue();

                    //recursive call for pushing node in queue
                    pushInQueue(temp, qsize - 1);
                }
            } catch (Exception ex) {
                Logger.getLogger(ListPhone.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * push node to the last by popping from front until size become 0
     *
     * @param qsize
     */
    void FrontToLast(int qsize) {
        if (qsize <= 0) {
            return;
        }
        try {
            //pop front node and push this last in the queue
            enqueue(front());
            dequeue();
            //recursize call for pushing element
            FrontToLast(qsize - 1);
        } catch (Exception e) {
        }

    }

    void enqueue(Phone el) {
        if (isEmpty()) {
            head = tail = new Node(el);
        } else {
            Node p = new Node(el);
            tail.next = p;
            //tail=p;//new Node(el);//
            tail = tail.next;
        }
    }

    Phone dequeue() throws Exception {
        Phone x = null;

        try {
            x = head.inf;
            head = head.next;
        } catch (Exception e) {
            System.out.println("Empty Queue");
        }

        return x;
    }

    Phone front() throws Exception {
        if (!isEmpty()) {
            return head.inf;
        }
        throw new Exception("DG");

    }

    Node f8_sort2() {
        //sort by price increment from head to last max price
        return null;
    }

    void traverse() {
        if (!isEmpty()) {
            Node p = head;
            String s1, s2, s3;
            while (p != null) {
                s1 = p.inf.type;
                s2 = p.inf.model;
                s3 = p.inf.price + "";
                System.out.print("(" + s1 + ", " + s2 + ", " + s3 + ");");
                p = p.next;
            }
            System.out.println("");
        }
    }

}
