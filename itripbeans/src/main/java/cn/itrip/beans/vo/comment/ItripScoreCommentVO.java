package cn.itrip.beans.vo.comment;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 返回前端-酒店各类评分VO
 */
public class ItripScoreCommentVO {
	private float avgPositionScore;//点评查询页面酒店的位置得分
	private float avgFacilitiesScore;//点评查询页面酒店的设施得分
	private float avgServiceScore;//点评查询页面酒店的服务得分
	private float avgHygieneScore;//点评查询页面酒店的卫生得分
	private float avgScore;//点评查询页面酒店的总体得分
	public float getAvgPositionScore() {
		return avgPositionScore;
	}
	public void setAvgPositionScore(float avgPositionScore) {
		this.avgPositionScore = avgPositionScore;
	}
	public float getAvgFacilitiesScore() {
		return avgFacilitiesScore;
	}
	public void setAvgFacilitiesScore(float avgFacilitiesScore) {
		this.avgFacilitiesScore = avgFacilitiesScore;
	}
	public float getAvgServiceScore() {
		return avgServiceScore;
	}
	public void setAvgServiceScore(float avgServiceScore) {
		this.avgServiceScore = avgServiceScore;
	}
	public float getAvgHygieneScore() {
		return avgHygieneScore;
	}
	public void setAvgHygieneScore(float avgHygieneScore) {
		this.avgHygieneScore = avgHygieneScore;
	}
	public float getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(float avgScore) {
		this.avgScore = avgScore;
	}
	
}
