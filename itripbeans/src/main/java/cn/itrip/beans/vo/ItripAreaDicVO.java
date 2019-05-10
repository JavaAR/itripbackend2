package cn.itrip.beans.vo;

import java.io.Serializable;

/**
 * 返回前端-区域VO
 * Created by XX on 17-5-11.
 */
public class ItripAreaDicVO implements Serializable{

    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
