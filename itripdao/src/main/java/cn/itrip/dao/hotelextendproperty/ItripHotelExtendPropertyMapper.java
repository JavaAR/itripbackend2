package cn.itrip.dao.hotelextendproperty;
import cn.itrip.beans.pojo.ItripHotelExtendProperty;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripHotelExtendPropertyMapper {

	public ItripHotelExtendProperty getItripHotelExtendPropertyById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotelExtendProperty>	getItripHotelExtendPropertyListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripHotelExtendPropertyCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

	public Integer updateItripHotelExtendProperty(ItripHotelExtendProperty itripHotelExtendProperty)throws Exception;

	public Integer deleteItripHotelExtendPropertyById(@Param(value = "id") Long id)throws Exception;

}
