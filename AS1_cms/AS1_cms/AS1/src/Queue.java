/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thang
 */
public class Queue {

    Node head, tail;

    boolean isEmpty() {
        return head == null;
    }

    void clear() {
        head = tail = null;
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
}
