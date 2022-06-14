package com.cg.model;

import java.sql.Date;

public class Bill {
    private int id_bill;
    private Date dateExport;
    private String name;
    private String drinks;
    private long price;
    private long quantity;
    private long tien_gui;
    private long oder;
    private long tien_du;
    private int user_id;
    private int cart_id;

    public Bill(int id_bill, Date dateExport, String name, String drinks, long price, long quantity, long tien_gui, long oder, long tien_du, int user_id, int cart_id) {
        this.id_bill = id_bill;
        this.dateExport = dateExport;
        this.name = name;
        this.drinks = drinks;
        this.price = price;
        this.quantity = quantity;
        this.tien_gui = tien_gui;
        this.oder = oder;
        this.tien_du = tien_du;
        this.user_id = user_id;
        this.cart_id = cart_id;
    }

    public Bill( int user_id, int cart_id,long tien_gui) {
        this.tien_gui = tien_gui;
        this.user_id = user_id;
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public Bill() {
    }

    public Bill(int id_bill, Date dateExport, String name, String drinks, long price, long quantity, long tien_gui, long oder, long tien_du) {
        this.id_bill = id_bill;
        this.dateExport = dateExport;
        this.name = name;
        this.drinks = drinks;
        this.price = price;
        this.quantity = quantity;
        this.tien_gui = tien_gui;
        this.oder = oder;
        this.tien_du = tien_du;
    }

    public int getId_bill() {
        return id_bill;
    }

    public void setId_bill(int id_bill) {
        this.id_bill = id_bill;
    }

    public Date getDateExport() {
        return dateExport;
    }

    public void setDateExport(Date dateExport) {
        this.dateExport = dateExport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getTien_gui() {
        return tien_gui;
    }

    public void setTien_gui(long tien_gui) {
        this.tien_gui = tien_gui;
    }

    public long getOder() {
        return oder;
    }

    public void setOder(long oder) {
        this.oder = oder;
    }

    public long getTien_du() {
        return tien_du;
    }

    public void setTien_du(long tien_du) {
        this.tien_du = tien_du;
    }
}
