/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thang
 */
public class Phone {

    String type, model;
    double price;

    public Phone() {
    }

    public Phone(String type, String model, double price) {
//        System.out.println(type +" "+model+" "+price);
        this.type = type;
        this.model = model;
        this.price = price;
    }

}
