package cn.itrip.beans.vo.hotel;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * 返回前端-酒店详情页视频文字描述（酒店特色、商圈、酒店名称）VO
 * Created by hanlu on 2017/5/24.
 */
@ApiModel(value = "HotelVideoDescVO",description = "酒店特色、商圈、酒店名称（视频文字描述）")

public class HotelVideoDescVO {

    private String hotelName;   //酒店名称

    private List<String> tradingAreaNameList; //酒店所属商圈

    private List<String> hotelFeatureList; //酒店特色

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<String> getTradingAreaNameList() {
        return tradingAreaNameList;
    }

    public void setTradingAreaNameList(List<String> tradingAreaNameList) {
        this.tradingAreaNameList = tradingAreaNameList;
    }

    public List<String> getHotelFeatureList() {
        return hotelFeatureList;
    }

    public void setHotelFeatureList(List<String> hotelFeatureList) {
        this.hotelFeatureList = hotelFeatureList;
    }
}
