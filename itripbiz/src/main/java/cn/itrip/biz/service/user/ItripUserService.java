package cn.itrip.biz.service.user;
import cn.itrip.beans.pojo.ItripUser;
import java.util.List;
import java.util.Map;

import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripUserService {

    public ItripUser getItripUserById(Long id)throws Exception;

    public List<ItripUser>	getItripUserListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripUserCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripUser(ItripUser itripUser)throws Exception;

    public Integer itriptxModifyItripUser(ItripUser itripUser)throws Exception;

    public Integer itriptxDeleteItripUserById(Long id)throws Exception;

    public Page<ItripUser> queryItripUserPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
