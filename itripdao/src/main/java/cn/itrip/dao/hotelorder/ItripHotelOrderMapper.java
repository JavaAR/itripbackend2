package cn.itrip.dao.hotelorder;
import cn.itrip.beans.pojo.ItripHotelOrder;
import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItripHotelOrderMapper {

	public ItripHotelOrder getItripHotelOrderById(@Param(value = "id") Long id)throws Exception;

	public ItripPersonalOrderRoomVO getItripHotelOrderRoomInfoById(@Param(value = "id") Long id)throws Exception;

	public List<ItripHotelOrder>	getItripHotelOrderListByMap(Map<String, Object> param)throws Exception;

	public Integer getItripHotelOrderCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception;

	public Integer updateItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception;

	public Integer deleteItripHotelOrderById(@Param(value = "id") Long id)throws Exception;

	public Integer updateHotelOrderStatus(@Param(value = "id") Long id, @Param(value = "modifiedBy") Long modifiedBy) throws Exception;

	public int getRoomNumByRoomIdTypeAndDate(Integer roomId, String startDate, String endDate) throws Exception;

	public int updateRoomStore(ItripHotelOrder hotelOrder) throws Exception;

	/**
	 * 获取订单列表 add by hanlu
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public List<ItripListHotelOrderVO> getOrderListByMap(Map<String, Object> param)throws Exception;
	/***
	 * 获取订单数量
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Integer getOrderCountByMap(Map<String, Object> param)throws Exception;
	/***
	 * 刷新取消订单状态(用于定时程序)
	 * @return
	 * @throws Exception
	 */
	public Integer flushCancelOrderStatus()throws Exception;
	/***
	 * 刷新已入住订单状态(用于定时程序)
	 * @return
	 * @throws Exception
	 */
	public Integer flushSuccessOrderStatus()throws Exception;

}
