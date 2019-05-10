package cn.itrip.biz.service.tradeends;
import cn.itrip.beans.pojo.ItripTradeEnds;
import java.util.List;
import java.util.Map;

import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripTradeEndsService {

    public ItripTradeEnds getItripTradeEndsById(Long id)throws Exception;

    public List<ItripTradeEnds>	getItripTradeEndsListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripTradeEndsCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripTradeEnds(ItripTradeEnds itripTradeEnds)throws Exception;

    public Integer itriptxModifyItripTradeEnds(Map<String, Object> param)throws Exception;

    public Integer itriptxDeleteItripTradeEndsById(Long id)throws Exception;

    public Page<ItripTradeEnds> queryItripTradeEndsPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
