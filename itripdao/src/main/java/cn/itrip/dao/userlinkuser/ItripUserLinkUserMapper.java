package cn.itrip.dao.userlinkuser;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripUserLinkUserMapper {

	public ItripUserLinkUser getItripUserLinkUserById(@Param(value = "id") Long id)throws Exception;

	/**
	 * 根据用户id查询常用联系人-add by donghai
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<ItripUserLinkUser> getItripUserLinkUserByUserId(@Param(value = "userId") Long userId)throws Exception;

	public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripUserLinkUserCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

	public Integer updateItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

	public Integer deleteItripUserLinkUserByIds(@Param(value = "ids") Long[] ids)throws Exception;

}
