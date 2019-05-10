package cn.itrip.dao.productstore;
import cn.itrip.beans.pojo.ItripProductStore;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripProductStoreMapper {

	public ItripProductStore getItripProductStoreById(@Param(value = "id") Long id)throws Exception;

	public List<ItripProductStore>	getItripProductStoreListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripProductStoreCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripProductStore(ItripProductStore itripProductStore)throws Exception;

	public Integer updateItripProductStore(ItripProductStore itripProductStore)throws Exception;

	public Integer deleteItripProductStoreById(@Param(value = "id") Long id)throws Exception;

}
