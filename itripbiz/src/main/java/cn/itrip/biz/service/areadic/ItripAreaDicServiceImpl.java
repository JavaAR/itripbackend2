package cn.itrip.biz.service.areadic;
import cn.itrip.beans.pojo.ItripAreaDic;
import cn.itrip.common.Constants;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.dao.areadic.ItripAreaDicMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service("itripAreaDicService")
public class ItripAreaDicServiceImpl implements ItripAreaDicService {

    @Resource
    private ItripAreaDicMapper itripAreaDicMapper;

    public ItripAreaDic getItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.getItripAreaDicById(id);
    }

    public List<ItripAreaDic>	getItripAreaDicListByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicListByMap(param);
    }

    public Integer getItripAreaDicCountByMap(Map<String,Object> param)throws Exception{
        return itripAreaDicMapper.getItripAreaDicCountByMap(param);
    }

    public Integer itriptxAddItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
            itripAreaDic.setCreationDate(new Date());
            return itripAreaDicMapper.insertItripAreaDic(itripAreaDic);
    }

    public Integer itriptxModifyItripAreaDic(ItripAreaDic itripAreaDic)throws Exception{
        itripAreaDic.setModifyDate(new Date());
        return itripAreaDicMapper.updateItripAreaDic(itripAreaDic);
    }

    public Integer itriptxDeleteItripAreaDicById(Long id)throws Exception{
        return itripAreaDicMapper.deleteItripAreaDicById(id);
    }

    public Page<ItripAreaDic> queryItripAreaDicPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripAreaDicMapper.getItripAreaDicCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripAreaDic> itripAreaDicList = itripAreaDicMapper.getItripAreaDicListByMap(param);
        page.setRows(itripAreaDicList);
        return page;
    }

}
