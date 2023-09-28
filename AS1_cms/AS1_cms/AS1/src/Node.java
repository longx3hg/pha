/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Thang
 */
public class Node {
    Phone inf;
    Node next;

    public Node() {
    }

    public Node(Phone inf, Node next) {
        this.inf = inf;
        this.next = next;
    }
    public Node(Phone inf) {      
       this(inf,null);
    }
    
}
