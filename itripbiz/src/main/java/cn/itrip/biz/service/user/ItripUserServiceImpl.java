package cn.itrip.biz.service.user;
import cn.itrip.dao.user.ItripUserMapper;
import cn.itrip.beans.pojo.ItripUser;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripUserServiceImpl implements ItripUserService {

    @Resource
    private ItripUserMapper itripUserMapper;

    public ItripUser getItripUserById(Long id)throws Exception{
        return itripUserMapper.getItripUserById(id);
    }

    public List<ItripUser>	getItripUserListByMap(Map<String,Object> param)throws Exception{
        return itripUserMapper.getItripUserListByMap(param);
    }

    public Integer getItripUserCountByMap(Map<String,Object> param)throws Exception{
        return itripUserMapper.getItripUserCountByMap(param);
    }

    public Integer itriptxAddItripUser(ItripUser itripUser)throws Exception{
            itripUser.setCreationDate(new Date());
            return itripUserMapper.insertItripUser(itripUser);
    }

    public Integer itriptxModifyItripUser(ItripUser itripUser)throws Exception{
        itripUser.setModifyDate(new Date());
        return itripUserMapper.updateItripUser(itripUser);
    }

    public Integer itriptxDeleteItripUserById(Long id)throws Exception{
        return itripUserMapper.deleteItripUserById(id);
    }

    public Page<ItripUser> queryItripUserPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripUserMapper.getItripUserCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripUser> itripUserList = itripUserMapper.getItripUserListByMap(param);
        page.setRows(itripUserList);
        return page;
    }

}
