package cn.itrip.beans.vo;

/**
 * 返回前端-图片对象VO
 * Created by hanlu on 2017/5/10.
 */
public class ItripImageVO {

    private Integer position;//页面图片展现顺序
    private String imgUrl;//图片的URL访问路径

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }




}
