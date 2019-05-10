package cn.itrip.biz.service.image;
import cn.itrip.beans.pojo.ItripImage;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.vo.ItripImageVO;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripImageService {

    public ItripImage getItripImageById(Long id)throws Exception;

    public List<ItripImageVO> getItripImageListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripImageCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripImage(ItripImage itripImage)throws Exception;

    public Integer itriptxModifyItripImage(ItripImage itripImage)throws Exception;

    public Integer itriptxDeleteItripImageById(Long id)throws Exception;

   /* public Page<ItripImage> queryItripImagePageByMap(Map<String,Object> param,Integer pageNo,Integer pageSize)throws Exception;*/
}
