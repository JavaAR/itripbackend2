package cn.itrip.dao.hotelfeature;
import cn.itrip.beans.pojo.ItripHotelFeature;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripHotelFeatureMapper {

	public ItripHotelFeature getItripHotelFeatureById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotelFeature>	getItripHotelFeatureListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripHotelFeatureCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripHotelFeature(ItripHotelFeature itripHotelFeature)throws Exception;

	public Integer updateItripHotelFeature(ItripHotelFeature itripHotelFeature)throws Exception;

	public Integer deleteItripHotelFeatureById(@Param(value = "id") Long id)throws Exception;

}
