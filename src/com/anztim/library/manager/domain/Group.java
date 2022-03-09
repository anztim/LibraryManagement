package com.anztim.library.manager.domain;

/**
 * @author anztim
 */
@SuppressWarnings("unused")
public class Group {
    private Integer	groupId;
    private Integer	basicCashPledge;
    private Integer	borrowLimit;
    private Integer	timeLimit;
    private Integer	renewLimit;

    public Group(Integer groupId, Integer basicCashPledge, Integer borrowLimit, Integer timeLimit, Integer renewLimit) {
        this.groupId = groupId;
        this.basicCashPledge = basicCashPledge;
        this.borrowLimit = borrowLimit;
        this.timeLimit = timeLimit;
        this.renewLimit = renewLimit;
    }

    public Group() {
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getBasicCashPledge() {
        return basicCashPledge;
    }

    public void setBasicCashPledge(Integer basicCashPledge) {
        this.basicCashPledge = basicCashPledge;
    }

    public Integer getBorrowLimit() {
        return borrowLimit;
    }

    public void setBorrowLimit(Integer borrowLimit) {
        this.borrowLimit = borrowLimit;
    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Integer timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getRenewLimit() {
        return renewLimit;
    }

    public void setRenewLimit(Integer renewLimit) {
        this.renewLimit = renewLimit;
    }
}
