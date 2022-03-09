package com.anztim.library.manager.domain;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Borrow {
    private Integer borrowId;
    private String position;
    private String bookId;
    private Integer userId;
    private String borrowDate;
    private String dueDate;
    private Integer renewCount;

    public Borrow() {
    }

    public Borrow(Integer borrowId, String position, String bookId, Integer userId, String borrowDate, String dueDate, int renewCount) {
        this.borrowId = borrowId;
        this.position = position;
        this.bookId = bookId;
        this.userId = userId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.renewCount = renewCount;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getRenewCount() {
        return renewCount;
    }

    public void setRenewCount(int renewCount) {
        this.renewCount = renewCount;
    }
}
