package cn.itrip.beans.pojo;

import java.io.Serializable;
import java.util.Date;

public class ItripOrderLinkUser implements Serializable {

    private Long id;
    private Long orderId;
    private Long linkUserId;
    private String linkUserName;
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

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setLinkUserId(Long linkUserId) {
        this.linkUserId = linkUserId;
    }

    public Long getLinkUserId() {
        return this.linkUserId;
    }

    public void setLinkUserName(String linkUserName) {
        this.linkUserName = linkUserName;
    }

    public String getLinkUserName() {
        return this.linkUserName;
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
