package cn.itrip.beans.vo;

import java.util.List;
import java.util.Map;

/**
 * 用于给前端返回统一数据的VO 目前只有TestController再用
 * Created by XX on 17-5-23.
 */
public class TempVO {

    private String rootName;

    private List<Map<String,Object>> leafs;

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    public List<Map<String, Object>> getLeafs() {
        return leafs;
    }

    public void setLeafs(List<Map<String, Object>> leafs) {
        this.leafs = leafs;
    }
}
