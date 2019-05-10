package cn.itrip.beans.vo.order;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by zezhong.shang on 17-5-16.
 */
@ApiModel(value = "PreAddOrderVO",description = "生成订单前获取预订信息的VO")
public class PreAddOrderVO implements Serializable{

    @ApiModelProperty("[必填，注：接收数字类型 酒店ID")
    private Long hotelId;
    @ApiModelProperty("[必填，注：接收数字类型 房间ID")
    private Long roomId;
    @ApiModelProperty("[必填，注：接收日期类型 入住时间")
    private Date checkInDate;
    @ApiModelProperty("[必填，注：接收日期类型 退房时间")
    private Date checkOutDate;
    @ApiModelProperty("[必填，默认请传1")
    private Integer count;

    private String hotelName;
    private Integer store;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public Long getRoomId() {
        return roomId;
    }

    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Integer getStore() {
        return store;
    }

    public void setStore(Integer store) {
        this.store = store;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
