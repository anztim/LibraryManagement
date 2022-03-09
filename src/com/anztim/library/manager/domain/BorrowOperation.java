package com.anztim.library.manager.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class BorrowOperation {
    private Integer operationId;
    private String type;
    private Integer borrowId;
    private Date borrowDate;
    private Date dueDate;
    private Timestamp operationTime;

    public BorrowOperation() {
    }

    public BorrowOperation(Integer operationId, String type, Integer borrowId, Date borrowDate, Date dueDate, Timestamp operationTime) {
        this.operationId = operationId;
        this.type = type;
        this.borrowId = borrowId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.operationTime = operationTime;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Timestamp getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Timestamp operationTime) {
        this.operationTime = operationTime;
    }
}
