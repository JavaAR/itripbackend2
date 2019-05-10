package cn.itrip.dao.image;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.vo.ItripImageVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripImageMapper {

	public ItripImage getItripImageById(@Param(value = "id") Long id)throws Exception;

	public List<ItripImageVO> getItripImageListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripImageCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripImage(ItripImage itripImage)throws Exception;

	public Integer updateItripImage(ItripImage itripImage)throws Exception;

	public Integer deleteItripImageById(@Param(value = "id") Long id)throws Exception;

}
