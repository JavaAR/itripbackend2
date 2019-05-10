package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ItripHotelRoom implements Serializable {

    private Long id;
    private Long hotelId;
    private String roomTitle;
    private BigDecimal roomPrice;
    private Long roomBedTypeId;
    private Integer isHavingBreakfast;
    private Integer payType;
    private Double satisfaction;
    private Integer isBook;
    private Integer isCancel;
    private Integer isTimelyResponse;
    private Date creationDate;
    private Long createdBy;
    private Date modifyDate;
    private Long modifiedBy;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getHotelId() {
        return this.hotelId;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }

    public String getRoomTitle() {
        return this.roomTitle;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public BigDecimal getRoomPrice() {
        return this.roomPrice;
    }

    public void setRoomBedTypeId(Long roomBedTypeId) {
        this.roomBedTypeId = roomBedTypeId;
    }

    public Long getRoomBedTypeId() {
        return this.roomBedTypeId;
    }

    public void setIsHavingBreakfast(Integer isHavingBreakfast) {
        this.isHavingBreakfast = isHavingBreakfast;
    }

    public Integer getIsHavingBreakfast() {
        return this.isHavingBreakfast;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public Integer getPayType() {
        return this.payType;
    }

    public void setSatisfaction(Double satisfaction) {
        this.satisfaction = satisfaction;
    }

    public Double getSatisfaction() {
        return this.satisfaction;
    }

    public void setIsBook(Integer isBook) {
        this.isBook = isBook;
    }

    public Integer getIsBook() {
        return this.isBook;
    }

    public void setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
    }

    public Integer getIsCancel() {
        return this.isCancel;
    }

    public void setIsTimelyResponse(Integer isTimelyResponse) {
        this.isTimelyResponse = isTimelyResponse;
    }

    public Integer getIsTimelyResponse() {
        return this.isTimelyResponse;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getModifyDate() {
        return this.modifyDate;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Long getModifiedBy() {
        return this.modifiedBy;
    }

}
