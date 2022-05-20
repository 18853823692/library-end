package com.crb.library.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author crb
 * @since 2022-05-19
 */
@TableName("borrow")
public class Borrow implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Integer readerNumber;

    private Integer bookNumber;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime planreturnTime;

    private Integer status;

    private String operator;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getReaderNumber() {
        return readerNumber;
    }

    public void setReaderNumber(Integer readerNumber) {
        this.readerNumber = readerNumber;
    }
    public Integer getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Integer bookNumber) {
        this.bookNumber = bookNumber;
    }
    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
    }
    public LocalDateTime getPlanreturnTime() {
        return planreturnTime;
    }

    public void setPlanreturnTime(LocalDateTime planreturnTime) {
        this.planreturnTime = planreturnTime;
    }
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Borrow{" +
            "id=" + id +
            ", readerNumber=" + readerNumber +
            ", bookNumber=" + bookNumber +
            ", borrowTime=" + borrowTime +
            ", planreturnTime=" + planreturnTime +
            ", status=" + status +
            ", operator=" + operator +
        "}";
    }
}
