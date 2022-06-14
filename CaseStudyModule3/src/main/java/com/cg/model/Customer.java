package com.cg.model;

public class Customer {
     private int id;
     private int oder_id;
     private String drinks;
     private String image;
     private long price;
     private long quantity;
     private long cash = price * quantity;
     private String note;
     private Long total;



     public Customer(Long total) {
          this.total = total;
     }


     public Customer(int id, String drinks, String image, long price, long quantity, long cash) {
          this.id = id;
          this.drinks = drinks;
          this.image = image;
          this.price = price;
          this.quantity = quantity;
          this.cash = cash;
     }

     public Customer(int oder_id, long quantity, long cash) {
          this.oder_id = oder_id;
          this.quantity = quantity;
          this.cash = cash;
     }

     public Customer(int id, int oder_id, String drinks, String image, long price, long quantity, long cash, String note) {
          this.id = id;
          this.oder_id = oder_id;
          this.drinks = drinks;
          this.image = image;
          this.price = price;
          this.quantity = quantity;
          this.cash = cash;
          this.note = note;
     }

     public Customer(String drinks, String image, long price, long quantity, long cash, String note) {
          this.drinks = drinks;
          this.image = image;
          this.price = price;
          this.quantity = quantity;
          this.cash = cash;
          this.note = note;
     }

     public Customer(int id, String drinks, long price, long quantity, String image, long cash) {
          this.id = id;
          this.drinks = drinks;
          this.price = price;
          this.quantity = quantity;
          this.image = image;
          this.cash = cash;
     }

     public Customer(int id, String drinks, long price, long quantity, String image) {
          this.id = id;
          this.drinks = drinks;
          this.price = price;
          this.quantity = quantity;
          this.image = image;
     }

     public Customer(int oder_id) {
          this.oder_id = oder_id;
     }

     public Customer(int id, long quantity) {
          this.id = id;
          this.quantity = quantity;
     }

     public Customer(String drinks, long price, String image) {
          this.drinks = drinks;
          this.price = price;
          this.image = image;
     }

     public Customer() {
     }

     public Customer(String drinks, String image, long price) {
          this.drinks = drinks;
          this.image = image;
          this.price = price;
     }

     public Customer(int id, String drinks, String image, long price) {
          this.id = id;
          this.drinks = drinks;
          this.image = image;
          this.price = price;
     }

     public Customer(String drinks, String image, long price, long quantity, long cash) {
          this.drinks = drinks;
          this.price = price;
          this.quantity = quantity;
          this.image = image;
          this.cash = cash;
     }
     public Long getTotal() {
          return total;
     }

     public void setTotal(Long total) {
          this.total = total;
     }
     public String getNote() {
          return note;
     }

     public void setNote(String note) {
          this.note = note;
     }

     public int getOder_id() {
          return oder_id;
     }

     public void setOder_id(int oder_id) {
          this.oder_id = oder_id;
     }
     public long getCash() {
          return cash;
     }

     public void setCash(long cash) {
          this.cash = cash;
     }

     public int getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
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

     public String getImage() {
          return image;
     }

     public void setImage(String image) {
          this.image = image;
     }




}
