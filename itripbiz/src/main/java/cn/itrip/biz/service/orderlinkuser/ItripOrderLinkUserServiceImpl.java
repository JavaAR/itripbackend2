package cn.itrip.biz.service.orderlinkuser;
import cn.itrip.beans.vo.order.ItripOrderLinkUserVo;
import cn.itrip.dao.orderlinkuser.ItripOrderLinkUserMapper;
import cn.itrip.beans.pojo.ItripOrderLinkUser;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripOrderLinkUserServiceImpl implements ItripOrderLinkUserService {

    @Resource
    private ItripOrderLinkUserMapper itripOrderLinkUserMapper;

    public ItripOrderLinkUser getItripOrderLinkUserById(Long id)throws Exception{
        return itripOrderLinkUserMapper.getItripOrderLinkUserById(id);
    }

    public List<ItripOrderLinkUserVo>	getItripOrderLinkUserListByMap(Map<String,Object> param)throws Exception{
        return itripOrderLinkUserMapper.getItripOrderLinkUserListByMap(param);
    }

    public Integer getItripOrderLinkUserCountByMap(Map<String,Object> param)throws Exception{
        return itripOrderLinkUserMapper.getItripOrderLinkUserCountByMap(param);
    }

    public Integer itriptxAddItripOrderLinkUser(ItripOrderLinkUser itripOrderLinkUser)throws Exception{
            itripOrderLinkUser.setCreationDate(new Date());
            return itripOrderLinkUserMapper.insertItripOrderLinkUser(itripOrderLinkUser);
    }

    public Integer itriptxModifyItripOrderLinkUser(ItripOrderLinkUser itripOrderLinkUser)throws Exception{
        itripOrderLinkUser.setModifyDate(new Date());
        return itripOrderLinkUserMapper.updateItripOrderLinkUser(itripOrderLinkUser);
    }

    public Integer itriptxDeleteItripOrderLinkUserById(Long id)throws Exception{
        return itripOrderLinkUserMapper.deleteItripOrderLinkUserById(id);
    }

    public List<Long> getItripOrderLinkUserIdsByOrder() throws Exception{
        return itripOrderLinkUserMapper.getItripOrderLinkUserIdsByOrder();
    }
}
