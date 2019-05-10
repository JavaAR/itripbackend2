package cn.itrip.beans.pojo;

/**
 * 订单支付完成后，系统需对该订单进行后续处理，如减库存等。<br/>
 * 本类映射一条等待处理的支付结果。
 * @author hduser
 *
 */
public class ItripTradeEnds {

	private Long id;		//订单ID
	private String orderNo;	//订单编号
	private Integer flag;	//处理标识 0：未处理；1：处理中
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	
}
