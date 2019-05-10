package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripUser implements Serializable {

            private Long id;
            private String userCode;
            private String userPassword;
            private Integer userType;
            private Long flatID;
            private String userName;
            private String weChat;
            private String QQ;
            private String weibo;
            private String baidu;
            private int activated;
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
            public void setUserCode (String  userCode){
                this.userCode=userCode;
            }

            public  String getUserCode(){
                return this.userCode;
            }
            public void setUserPassword (String  userPassword){
                this.userPassword=userPassword;
            }

            public  String getUserPassword(){
                return this.userPassword;
            }
            public void setUserType (Integer  userType){
                this.userType=userType;
            }

            public  Integer getUserType(){
                return this.userType;
            }
            public void setFlatID (Long  flatID){
                this.flatID=flatID;
            }

            public  Long getFlatID(){
                return this.flatID;
            }
            public void setUserName (String  userName){
                this.userName=userName;
            }

            public  String getUserName(){
                return this.userName;
            }
            public void setWeChat (String  weChat){
                this.weChat=weChat;
            }

            public  String getWeChat(){
                return this.weChat;
            }
            public void setQQ (String  QQ){
                this.QQ=QQ;
            }

            public  String getQQ(){
                return this.QQ;
            }
            public void setWeibo (String  weibo){
                this.weibo=weibo;
            }

            public  String getWeibo(){
                return this.weibo;
            }
            public void setBaidu (String  baidu){
                this.baidu=baidu;
            }

            public  String getBaidu(){
                return this.baidu;
            }

            public int getActivated() {
                return activated;
            }

            public void setActivated(int activated) {
                this.activated = activated;
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
