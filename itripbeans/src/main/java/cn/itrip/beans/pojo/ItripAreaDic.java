package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;
public class ItripAreaDic implements Serializable {

            private Long id;
            private String name;
            private String areaNo;
            private Long parent;
            private Integer isActivated;
            private Integer isTradingArea;
            private Integer isHot;
            private Integer level;
            private Integer isChina;
            private String pinyin;
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
            public void setName (String  name){
                this.name=name;
            }

            public  String getName(){
                return this.name;
            }
            public void setAreaNo (String  areaNo){
                this.areaNo=areaNo;
            }

            public  String getAreaNo(){
                return this.areaNo;
            }
            public void setParent (Long  parent){
                this.parent=parent;
            }

            public  Long getParent(){
                return this.parent;
            }
            public void setIsActivated (Integer  isActivated){
                this.isActivated=isActivated;
            }

            public  Integer getIsActivated(){
                return this.isActivated;
            }
            public void setIsTradingArea (Integer  isTradingArea){
                this.isTradingArea=isTradingArea;
            }

            public  Integer getIsTradingArea(){
                return this.isTradingArea;
            }
            public void setIsHot (Integer  isHot){
                this.isHot=isHot;
            }

            public  Integer getIsHot(){
                return this.isHot;
            }
            public void setLevel (Integer  level){
                this.level=level;
            }

            public  Integer getLevel(){
                return this.level;
            }
            public void setIsChina (Integer  isChina){
                this.isChina=isChina;
            }

            public  Integer getIsChina(){
                return this.isChina;
            }
            public void setPinyin (String  pinyin){
                this.pinyin=pinyin;
            }

            public  String getPinyin(){
                return this.pinyin;
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
