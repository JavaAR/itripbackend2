package cn.itrip.biz.service.comment;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.beans.vo.comment.ItripScoreCommentVO;
import cn.itrip.common.BigDecimalUtil;
import cn.itrip.common.Constants;
import cn.itrip.common.EmptyUtils;
import cn.itrip.common.Page;
import cn.itrip.dao.comment.ItripCommentMapper;
import cn.itrip.dao.hotelorder.ItripHotelOrderMapper;
import cn.itrip.dao.image.ItripImageMapper;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service("itripCommentService")
public class ItripCommentServiceImpl implements ItripCommentService {
    private Logger logger = Logger.getLogger(ItripCommentServiceImpl.class);
    @Resource
    private ItripCommentMapper itripCommentMapper;
    @Resource
    private ItripImageMapper itripImageMapper;
    @Resource
    private ItripHotelOrderMapper itripHotelOrderMapper;


    public ItripComment getItripCommentById(Long id)throws Exception{
        return itripCommentMapper.getItripCommentById(id);
    }

    public List<ItripListCommentVO> getItripCommentListByMap(Map<String,Object> param)throws Exception{
        return itripCommentMapper.getItripCommentListByMap(param);
    }

    public Integer getItripCommentCountByMap(Map<String,Object> param)throws Exception{
        return itripCommentMapper.getItripCommentCountByMap(param);
    }

    /**
     * 新增评论信息-add by hanlu
     * @param obj
     * @param itripImages
     * @return
     * @throws Exception
     */
    public boolean itriptxAddItripComment(ItripComment obj, List<ItripImage> itripImages)throws Exception{
        if(null != obj ){
            //计算综合评分，综合评分=(设施+卫生+位置+服务)/4
            float score = 0;
            int sum = obj.getFacilitiesScore()+obj.getHygieneScore()+obj.getPositionScore()+obj.getServiceScore();
            score = BigDecimalUtil.OperationASMD(sum,4, BigDecimalUtil.BigDecimalOprations.divide,1, BigDecimal.ROUND_DOWN).floatValue();
            //对结果四舍五入
            obj.setScore(Math.round(score));
            Long commentId = 0L;
            if(itripCommentMapper.insertItripComment(obj) > 0 ){
                commentId = obj.getId();
                logger.debug("新增评论id：================ " + commentId);
                if(null != itripImages && itripImages.size() > 0 && commentId > 0){
                    for (ItripImage itripImage:itripImages) {
                        itripImage.setTargetId(commentId);
                        itripImageMapper.insertItripImage(itripImage);
                    }
                }
                //更新订单表-订单状态为4（已评论）
                itripHotelOrderMapper.updateHotelOrderStatus(obj.getOrderId(),obj.getCreatedBy());
                return true;
            }
        }
        return false;
    }

    public Integer itriptxModifyItripComment(ItripComment itripComment)throws Exception{
        itripComment.setModifyDate(new Date());
        return itripCommentMapper.updateItripComment(itripComment);
    }

    public Integer itriptxDeleteItripCommentById(Long id)throws Exception{
        return itripCommentMapper.deleteItripCommentById(id);
    }

    public Page<ItripListCommentVO> queryItripCommentPageByMap(Map<String,Object> param, Integer pageNo, Integer pageSize)throws Exception{
        Integer total = itripCommentMapper.getItripCommentCountByMap(param);
        pageNo = EmptyUtils.isEmpty(pageNo) ? Constants.DEFAULT_PAGE_NO : pageNo;
        pageSize = EmptyUtils.isEmpty(pageSize) ? Constants.DEFAULT_PAGE_SIZE : pageSize;
        Page page = new Page(pageNo, pageSize, total);
        param.put("beginPos", page.getBeginPos());
        param.put("pageSize", page.getPageSize());
        List<ItripListCommentVO> itripCommentList = itripCommentMapper.getItripCommentListByMap(param);
        page.setRows(itripCommentList);
        return page;
    }

    @Override
    public ItripScoreCommentVO getAvgAndTotalScore(Long hotelId) throws Exception {
        return itripCommentMapper.getCommentAvgScore(hotelId);
    }
}
