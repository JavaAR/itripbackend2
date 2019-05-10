package cn.itrip.biz.service.comment;
import cn.itrip.beans.pojo.ItripComment;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.pojo.ItripImage;
import cn.itrip.beans.vo.comment.ItripScoreCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripCommentService {

    public ItripComment getItripCommentById(Long id)throws Exception;

    public List<ItripListCommentVO>	getItripCommentListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripCommentCountByMap(Map<String, Object> param)throws Exception;

    /**
     * 添加点评-add by hanlu
     * @param obj
     * @param itripImages
     * @return
     * @throws Exception
     */
    public boolean itriptxAddItripComment(ItripComment obj, List<ItripImage> itripImages)throws Exception;

    public Integer itriptxModifyItripComment(ItripComment itripComment)throws Exception;

    public Integer itriptxDeleteItripCommentById(Long id)throws Exception;

    public Page<ItripListCommentVO> queryItripCommentPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    /**
     * 根据酒店的id查询并计算所有点评的位置、设施、服务、卫生和综合评分-add by donghai
     * @param hotelId
     * @return
     * @throws Exception
     */
    public ItripScoreCommentVO getAvgAndTotalScore(Long hotelId) throws Exception;
}
