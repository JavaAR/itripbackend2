package cn.itrip.dao.labeldic;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.beans.vo.ItripLabelDicVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripLabelDicMapper {

	public ItripLabelDic getItripLabelDicById(@Param(value = "id") Long id)throws Exception;

	public List<ItripLabelDic>	getItripLabelDicListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripLabelDicCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripLabelDic(ItripLabelDic itripLabelDic)throws Exception;

	public Integer updateItripLabelDic(ItripLabelDic itripLabelDic)throws Exception;

	public Integer deleteItripLabelDicById(@Param(value = "id") Long id)throws Exception;

	/**
	 * 根据parentId查询数据字典
	 * @param parentId
	 * @return
	 * @throws Exception
	 * add by hanlu 2017-5-11
	 */
	public List<ItripLabelDicVO> getItripLabelDicByParentId(@Param(value = "parentId") Long parentId)throws Exception;

}
