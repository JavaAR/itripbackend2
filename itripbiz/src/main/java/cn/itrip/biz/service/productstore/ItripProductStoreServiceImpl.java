package cn.itrip.biz.service.productstore;
import cn.itrip.dao.productstore.ItripProductStoreMapper;
import cn.itrip.beans.pojo.ItripProductStore;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripProductStoreServiceImpl implements ItripProductStoreService {

    @Resource
    private ItripProductStoreMapper itripProductStoreMapper;

    public ItripProductStore getItripProductStoreById(Long id)throws Exception{
        return itripProductStoreMapper.getItripProductStoreById(id);
    }

    public List<ItripProductStore>	getItripProductStoreListByMap(Map<String,Object> param)throws Exception{
        return itripProductStoreMapper.getItripProductStoreListByMap(param);
    }

    public Integer getItripProductStoreCountByMap(Map<String,Object> param)throws Exception{
        return itripProductStoreMapper.getItripProductStoreCountByMap(param);
    }

    public Integer itriptxAddItripProductStore(ItripProductStore itripProductStore)throws Exception{
            itripProductStore.setCreationDate(new Date());
            return itripProductStoreMapper.insertItripProductStore(itripProductStore);
    }

    public Integer itriptxModifyItripProductStore(ItripProductStore itripProductStore)throws Exception{
        itripProductStore.setModifyDate(new Date());
        return itripProductStoreMapper.updateItripProductStore(itripProductStore);
    }

    public Integer itriptxDeleteItripProductStoreById(Long id)throws Exception{
        return itripProductStoreMapper.deleteItripProductStoreById(id);
    }

    public Page<ItripProductStore> queryItripProductStorePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripProductStoreMapper.getItripProductStoreCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripProductStore> itripProductStoreList = itripProductStoreMapper.getItripProductStoreListByMap(param);
        page.setRows(itripProductStoreList);
        return page;
    }

}
