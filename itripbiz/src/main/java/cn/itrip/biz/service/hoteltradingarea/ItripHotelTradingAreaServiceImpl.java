package cn.itrip.biz.service.hoteltradingarea;
import cn.itrip.dao.hoteltradingarea.ItripHotelTradingAreaMapper;
import cn.itrip.beans.pojo.ItripHotelTradingArea;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripHotelTradingAreaServiceImpl implements ItripHotelTradingAreaService {

    @Resource
    private ItripHotelTradingAreaMapper itripHotelTradingAreaMapper;

    public ItripHotelTradingArea getItripHotelTradingAreaById(Long id)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaById(id);
    }

    public List<ItripHotelTradingArea>	getItripHotelTradingAreaListByMap(Map<String,Object> param)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaListByMap(param);
    }

    public Integer getItripHotelTradingAreaCountByMap(Map<String,Object> param)throws Exception{
        return itripHotelTradingAreaMapper.getItripHotelTradingAreaCountByMap(param);
    }

    public Integer itriptxAddItripHotelTradingArea(ItripHotelTradingArea itripHotelTradingArea)throws Exception{
            itripHotelTradingArea.setCreationDate(new Date());
            return itripHotelTradingAreaMapper.insertItripHotelTradingArea(itripHotelTradingArea);
    }

    public Integer itriptxModifyItripHotelTradingArea(ItripHotelTradingArea itripHotelTradingArea)throws Exception{
        itripHotelTradingArea.setModifyDate(new Date());
        return itripHotelTradingAreaMapper.updateItripHotelTradingArea(itripHotelTradingArea);
    }

    public Integer itriptxDeleteItripHotelTradingAreaById(Long id)throws Exception{
        return itripHotelTradingAreaMapper.deleteItripHotelTradingAreaById(id);
    }

    public Page<ItripHotelTradingArea> queryItripHotelTradingAreaPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripHotelTradingAreaMapper.getItripHotelTradingAreaCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripHotelTradingArea> itripHotelTradingAreaList = itripHotelTradingAreaMapper.getItripHotelTradingAreaListByMap(param);
        page.setRows(itripHotelTradingAreaList);
        return page;
    }

}
