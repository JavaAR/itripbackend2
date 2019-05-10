package cn.itrip.biz.service.userlinkuser;
import cn.itrip.beans.pojo.ItripUserLinkUser;
import java.util.List;
import java.util.Map;

import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripUserLinkUserService {

    public ItripUserLinkUser getItripUserLinkUserById(Long id)throws Exception;

    public List<ItripUserLinkUser> getItripUserLinkUserByUserId(Long userId)throws Exception;

    public List<ItripUserLinkUser>	getItripUserLinkUserListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripUserLinkUserCountByMap(Map<String, Object> param)throws Exception;

    public Integer addItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

    public Integer modifyItripUserLinkUser(ItripUserLinkUser itripUserLinkUser)throws Exception;

    public Integer deleteItripUserLinkUserByIds(Long[] ids)throws Exception;

    public Page<ItripUserLinkUser> queryItripUserLinkUserPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
