package cn.itrip.dao.comment;
import cn.itrip.beans.pojo.ItripComment;
import cn.itrip.beans.vo.comment.ItripScoreCommentVO;
import cn.itrip.beans.vo.comment.ItripListCommentVO;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface ItripCommentMapper {

	public ItripComment getItripCommentById(@Param(value = "id") Long id)throws Exception;

	public List<ItripListCommentVO> getItripCommentListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripCommentCountByMap(Map<String, Object> param)throws Exception;

	public Long insertItripComment(ItripComment itripComment)throws Exception;

	public Integer updateItripComment(ItripComment itripComment)throws Exception;

	public Integer deleteItripCommentById(@Param(value = "id") Long id)throws Exception;

	public Long insert(ItripComment record);

	public ItripScoreCommentVO getCommentAvgScore(@Param(value = "hotelId") Long hotelId) throws Exception;
}
