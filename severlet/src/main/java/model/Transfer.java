package model;

import java.util.Date;

public class Transfer {
    private int id;
    private boolean deletel;
    private Date createdAt;
    private long createdBy;
    private Date updatedAt;
    private Long updatedBy;
    private int fees;
    private long fees_Amount;
    private long transactionAmount;
    private long transferAmount;
    private int recipientId;
    private int senderId;

    public Transfer() {
    }

    public Transfer(int id, boolean deletel, Date createdAt, long createdBy, Date updatedAt, Long updatedBy, int fees, long fees_Amount, long transactionAmount, long transferAmount, int recipientId, int senderId) {
        this.id = id;
        this.deletel = deletel;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.fees = fees;
        this.fees_Amount = fees_Amount;
        this.transactionAmount = transactionAmount;
        this.transferAmount = transferAmount;
        this.recipientId = recipientId;
        this.senderId = senderId;
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



    public int getFees() {
        return fees;
    }

    public void setFees(int fees) {
        this.fees = fees;
    }

    public long getFees_Amount() {
        return fees_Amount;
    }

    public void setFees_Amount(long fees_Amount) {
        this.fees_Amount = fees_Amount;
    }

    public long getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(long transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public long getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(long transferAmount) {
        this.transferAmount = transferAmount;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
}
