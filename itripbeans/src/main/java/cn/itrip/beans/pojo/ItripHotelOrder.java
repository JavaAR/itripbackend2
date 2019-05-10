package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
public class ItripHotelOrder implements Serializable {

            private Long id;
            private Long userId;
            private Integer orderType;
            private String orderNo;
            private String tradeNo;
            private Long hotelId;
            private String hotelName;
            private Long roomId;
            private Integer count;
            private Integer bookingDays;
            private Date checkInDate;
            private Date checkOutDate;
            private Integer orderStatus;
            private BigDecimal payAmount;
            private Integer payType;
            private String noticePhone;
            private String noticeEmail;
            private String specialRequirement;
            private Integer isNeedInvoice;
            private Integer invoiceType;
            private String invoiceHead;
            private String linkUserName;
            private Date creationDate;
            private Long createdBy;
            private Date modifyDate;
            private Long modifiedBy;
            private Integer bookType;

    public Integer getBookType() {
        return bookType;
    }

    public void setBookType(Integer bookType) {
        this.bookType = bookType;
    }

    public void setId (Long  id){
                this.id=id;
            }

            public  Long getId(){
                return this.id;
            }
            public void setUserId (Long  userId){
                this.userId=userId;
            }

            public  Long getUserId(){
                return this.userId;
            }
            public void setOrderType (Integer  orderType){
                this.orderType=orderType;
            }

            public  Integer getOrderType(){
                return this.orderType;
            }
            public void setOrderNo (String  orderNo){
                this.orderNo=orderNo;
            }

            public  String getOrderNo(){
                return this.orderNo;
            }
            public void setTradeNo (String  tradeNo){
                this.tradeNo=tradeNo;
            }

            public  String getTradeNo(){
                return this.tradeNo;
            }
            public void setHotelId (Long  hotelId){
                this.hotelId=hotelId;
            }

            public  Long getHotelId(){
                return this.hotelId;
            }
            public void setHotelName (String  hotelName){
                this.hotelName=hotelName;
            }

            public  String getHotelName(){
                return this.hotelName;
            }
            public void setRoomId (Long  roomId){
                this.roomId=roomId;
            }

            public  Long getRoomId(){
                return this.roomId;
            }
            public void setCount (Integer  count){
                this.count=count;
            }

            public  Integer getCount(){
                return this.count;
            }
            public void setBookingDays (Integer  bookingDays){
                this.bookingDays=bookingDays;
            }

            public  Integer getBookingDays(){
                return this.bookingDays;
            }
            public void setCheckInDate (Date  checkInDate){
                this.checkInDate=checkInDate;
            }

            public  Date getCheckInDate(){
                return this.checkInDate;
            }
            public void setCheckOutDate (Date  checkOutDate){
                this.checkOutDate=checkOutDate;
            }

            public  Date getCheckOutDate(){
                return this.checkOutDate;
            }
            public void setOrderStatus (Integer  orderStatus){
                this.orderStatus=orderStatus;
            }

            public  Integer getOrderStatus(){
                return this.orderStatus;
            }
            public void setPayAmount (BigDecimal  payAmount){
                this.payAmount=payAmount;
            }

            public  BigDecimal getPayAmount(){
                return this.payAmount;
            }
            public void setPayType (Integer  payType){
                this.payType=payType;
            }

            public  Integer getPayType(){
                return this.payType;
            }
            public void setNoticePhone (String  noticePhone){
                this.noticePhone=noticePhone;
            }

            public  String getNoticePhone(){
                return this.noticePhone;
            }
            public void setNoticeEmail (String  noticeEmail){
                this.noticeEmail=noticeEmail;
            }

            public  String getNoticeEmail(){
                return this.noticeEmail;
            }
            public void setSpecialRequirement (String  specialRequirement){
                this.specialRequirement=specialRequirement;
            }

            public  String getSpecialRequirement(){
                return this.specialRequirement;
            }
            public void setIsNeedInvoice (Integer  isNeedInvoice){
                this.isNeedInvoice=isNeedInvoice;
            }

            public  Integer getIsNeedInvoice(){
                return this.isNeedInvoice;
            }
            public void setInvoiceType (Integer  invoiceType){
                this.invoiceType=invoiceType;
            }

            public  Integer getInvoiceType(){
                return this.invoiceType;
            }
            public void setInvoiceHead (String  invoiceHead){
                this.invoiceHead=invoiceHead;
            }

            public  String getInvoiceHead(){
                return this.invoiceHead;
            }
            public void setCreationDate (Date  creationDate){
                this.creationDate=creationDate;
            }

            public  Date getCreationDate(){
                return this.creationDate;
            }
            public void setCreatedBy (Long  createdBy){
                this.createdBy=createdBy;
            }

            public  Long getCreatedBy(){
                return this.createdBy;
            }
            public void setModifyDate (Date  modifyDate){
                this.modifyDate=modifyDate;
            }

            public  Date getModifyDate(){
                return this.modifyDate;
            }
            public void setModifiedBy (Long  modifiedBy){
                this.modifiedBy=modifiedBy;
            }

            public  Long getModifiedBy(){
                return this.modifiedBy;
            }

            public String getLinkUserName() {
                return linkUserName;
            }

            public void setLinkUserName(String linkUserName) {
                this.linkUserName = linkUserName;
            }
}
