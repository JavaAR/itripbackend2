package cn.itrip.biz.service.labeldic;
import cn.itrip.beans.vo.ItripLabelDicVO;
import cn.itrip.dao.labeldic.ItripLabelDicMapper;
import cn.itrip.beans.pojo.ItripLabelDic;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import cn.itrip.common.Constants;
@Service
public class ItripLabelDicServiceImpl implements ItripLabelDicService {

    @Resource
    private ItripLabelDicMapper itripLabelDicMapper;

    public ItripLabelDic getItripLabelDicById(Long id)throws Exception{
        return itripLabelDicMapper.getItripLabelDicById(id);
    }

    public List<ItripLabelDic>	getItripLabelDicListByMap(Map<String,Object> param)throws Exception{
        return itripLabelDicMapper.getItripLabelDicListByMap(param);
    }

    public Integer getItripLabelDicCountByMap(Map<String,Object> param)throws Exception{
        return itripLabelDicMapper.getItripLabelDicCountByMap(param);
    }

    public Integer itriptxAddItripLabelDic(ItripLabelDic itripLabelDic)throws Exception{
            itripLabelDic.setCreationDate(new Date());
            return itripLabelDicMapper.insertItripLabelDic(itripLabelDic);
    }

    public Integer itriptxModifyItripLabelDic(ItripLabelDic itripLabelDic)throws Exception{
        itripLabelDic.setModifyDate(new Date());
        return itripLabelDicMapper.updateItripLabelDic(itripLabelDic);
    }

    public Integer itriptxDeleteItripLabelDicById(Long id)throws Exception{
        return itripLabelDicMapper.deleteItripLabelDicById(id);
    }

    public Page<ItripLabelDic> queryItripLabelDicPageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception{
        Integer total = itripLabelDicMapper.getItripLabelDicCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripLabelDic> itripLabelDicList = itripLabelDicMapper.getItripLabelDicListByMap(param);
        page.setRows(itripLabelDicList);
        return page;
    }


    /**
     * 根据parentId查询数据字典
     * @param parentId
     * @return
     * @throws Exception
     * add by hanlu 2017-5-11
     */
    public List<ItripLabelDicVO> getItripLabelDicByParentId(Long parentId)throws Exception{
        return itripLabelDicMapper.getItripLabelDicByParentId(parentId);
    }

}
