package model;

import java.util.Date;

public class Customers {
    private int id;
    private String full_name;
    private String email;
    private String phone;
    private String address;
    private Long balance;
    private boolean deletel;
    private Date createdAt;
    private long createdBy;
    private Date updatedAt;
    private Long updatedBy;
    private int ids;
    private Long transferAmount;

    public int getIds() {
        return ids;
    }

    public void setIds(int ids) {
        this.ids = ids;
    }

    public Long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(Long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Customers(int id,int ids, Long balance, Long transferAmount) {
        this.id = id;
        this.balance = balance;
        this.ids = ids;
        this.transferAmount = transferAmount;
    }

    public Customers(int id, int ids, Long transferAmount) {
        this.id = id;
        this.ids = ids;
        this.transferAmount = transferAmount;
    }

    public Customers(int id, String full_name, String email, String phone, String address, Long balance, boolean deletel, Date createdAt, long createdBy, Date updatedAt, Long updatedBy, int ids, Long transferAmount) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deletel = deletel;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.ids = ids;
        this.transferAmount = transferAmount;
    }

    public Customers(String full_name, String email, String phone, String address) {
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;

    }

    public boolean isDeletel() {
        return deletel;
    }

    public void setDeletel(boolean deletel) {
        this.deletel = deletel;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Long updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Customers(int id, String full_name, String email, String phone, String address, Long balance, boolean deletel, Date createdAt, long createdBy, Date updatedAt, Long updatedBy) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;
        this.deletel = deletel;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }

    public Customers() {
    }

    public Customers(int id, String full_name, String email, Long balance) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.balance = balance;
    }

    public Customers(int id , Long balance) {
        this.id = id;

        this.balance = balance;
    }

    public Customers(int id,String full_name , Long balance) {
        this.id = id;
        this.full_name = full_name;
        this.balance = balance;
    }

    public Customers(int id, String full_name, String email, String phone, String address, Long balance) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.balance = balance;

    }

    public Customers(int id, String full_name, String email, String phone, String address) {
        this.id = id;
        this.full_name = full_name;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

}
