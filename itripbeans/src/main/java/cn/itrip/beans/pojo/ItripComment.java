package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripComment implements Serializable {

            private Long id;
            private Long hotelId;
            private Long productId;
            private Long orderId;
            private Integer productType;
            private String content;
            private Long userId;
            private Integer isHavingImg;
            private Integer positionScore;
            private Integer facilitiesScore;
            private Integer serviceScore;
            private Integer hygieneScore;
            private Integer score;
            private String tripMode;
            private Integer isOk;
            private Date creationDate;
            private Long createdBy;
            private Date modifyDate;
            private Long modifiedBy;

            public void setId (Long  id){
                this.id=id;
            }

            public  Long getId(){
                return this.id;
            }
            public void setHotelId (Long  hotelId){
                this.hotelId=hotelId;
            }

            public  Long getHotelId(){
                return this.hotelId;
            }
            public void setProductId (Long  productId){
                this.productId=productId;
            }

            public  Long getProductId(){
                return this.productId;
            }
            public void setOrderId (Long  orderId){
                this.orderId=orderId;
            }

            public  Long getOrderId(){
                return this.orderId;
            }
            public void setProductType (Integer  productType){
                this.productType=productType;
            }

            public  Integer getProductType(){
                return this.productType;
            }
            public void setContent (String  content){
                this.content=content;
            }

            public  String getContent(){
                return this.content;
            }
            public void setUserId (Long  userId){
                this.userId=userId;
            }

            public  Long getUserId(){
                return this.userId;
            }
            public void setIsHavingImg (Integer  isHavingImg){
                this.isHavingImg=isHavingImg;
            }

            public  Integer getIsHavingImg(){
                return this.isHavingImg;
            }
            public void setPositionScore (Integer  positionScore){
                this.positionScore=positionScore;
            }

            public  Integer getPositionScore(){
                return this.positionScore;
            }
            public void setFacilitiesScore (Integer  facilitiesScore){
                this.facilitiesScore=facilitiesScore;
            }

            public  Integer getFacilitiesScore(){
                return this.facilitiesScore;
            }
            public void setServiceScore (Integer  serviceScore){
                this.serviceScore=serviceScore;
            }

            public  Integer getServiceScore(){
                return this.serviceScore;
            }
            public void setHygieneScore (Integer  hygieneScore){
                this.hygieneScore=hygieneScore;
            }

            public  Integer getHygieneScore(){
                return this.hygieneScore;
            }
            public void setScore (Integer  score){
                this.score=score;
            }

            public  Integer getScore(){
                return this.score;
            }
            public void setTripMode (String  tripMode){
                this.tripMode=tripMode;
            }

            public  String getTripMode(){
                return this.tripMode;
            }
            public void setIsOk (Integer  isOk){
                this.isOk=isOk;
            }

            public  Integer getIsOk(){
                return this.isOk;
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

}
