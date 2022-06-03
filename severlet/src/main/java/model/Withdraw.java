package model;

import java.util.Date;

public class Withdraw {
    private int id;
    private boolean deletel;
    private Date createdAt;
    private long createdBy;
    private Date updatedAt;
    private Long updatedBy;
    private int customerId;
    private long transactionAmount;


    public Withdraw() {
    }

    public Withdraw(int id, boolean deletel, Date createdAt, long createdBy, Date updatedAt, Long updatedBy, int customerId, long transactionAmount) {
        this.id = id;
        this.deletel = deletel;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.customerId = customerId;
        this.transactionAmount = transactionAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}
