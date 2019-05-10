package cn.itrip.dao.tradeends;
import cn.itrip.beans.pojo.ItripTradeEnds;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripTradeEndsMapper {

	public ItripTradeEnds getItripTradeEndsById(@Param(value = "id") Long id)throws Exception;

	public List<ItripTradeEnds>	getItripTradeEndsListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripTradeEndsCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripTradeEnds(ItripTradeEnds itripTradeEnds)throws Exception;

	public Integer updateItripTradeEnds(Map<String, Object> param)throws Exception;

	public Integer deleteItripTradeEndsById(@Param(value = "id") Long id)throws Exception;

}
