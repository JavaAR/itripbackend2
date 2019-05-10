package cn.itrip.biz.service.hotelfeature;
import cn.itrip.dao.hotelfeature.ItripHotelFeatureMapper;
import cn.itrip.beans.pojo.ItripHotelFeature;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripHotelFeatureServiceImpl implements ItripHotelFeatureService {

    @Resource
    private ItripHotelFeatureMapper itripHotelFeatureMapper;

    public ItripHotelFeature getItripHotelFeatureById(Long id)throws Exception{
        return itripHotelFeatureMapper.getItripHotelFeatureById(id);
    }

    public List<ItripHotelFeature>	getItripHotelFeatureListByMap(Map<String,Object> param)throws Exception{
        return itripHotelFeatureMapper.getItripHotelFeatureListByMap(param);
    }

    public Integer getItripHotelFeatureCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelFeatureMapper.getItripHotelFeatureCountByMap(param);
    }

    public Integer itriptxAddItripHotelFeature(ItripHotelFeature itripHotelFeature)throws Exception{
            itripHotelFeature.setCreationDate(new Date());
            return itripHotelFeatureMapper.insertItripHotelFeature(itripHotelFeature);
    }

    public Integer itriptxModifyItripHotelFeature(ItripHotelFeature itripHotelFeature)throws Exception{
        itripHotelFeature.setModifyDate(new Date());
        return itripHotelFeatureMapper.updateItripHotelFeature(itripHotelFeature);
    }

    public Integer itriptxDeleteItripHotelFeatureById(Long id)throws Exception{
        return itripHotelFeatureMapper.deleteItripHotelFeatureById(id);
    }

    public Page<ItripHotelFeature> queryItripHotelFeaturePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripHotelFeatureMapper.getItripHotelFeatureCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripHotelFeature> itripHotelFeatureList = itripHotelFeatureMapper.getItripHotelFeatureListByMap(param);
        page.setRows(itripHotelFeatureList);
        return page;
    }

}
