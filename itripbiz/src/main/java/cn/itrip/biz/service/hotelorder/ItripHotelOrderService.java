package cn.itrip.biz.service.hotelorder;
import cn.itrip.beans.pojo.ItripHotelOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.pojo.ItripUserLinkUser;
import cn.itrip.beans.vo.order.ItripListHotelOrderVO;
import cn.itrip.beans.vo.order.ItripPersonalOrderRoomVO;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelOrderService {

    public ItripHotelOrder getItripHotelOrderById(Long id)throws Exception;

    public List<ItripHotelOrder>	getItripHotelOrderListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelOrderCountByMap(Map<String, Object> param)throws Exception;

    public Map<String, String> itriptxAddItripHotelOrder(ItripHotelOrder itripHotelOrder, List<ItripUserLinkUser> itripOrderLinkUserList)throws Exception;

    public Integer itriptxModifyItripHotelOrder(ItripHotelOrder itripHotelOrder)throws Exception;

    public Integer itriptxDeleteItripHotelOrderById(Long id)throws Exception;

    public Page<ItripHotelOrder> queryItripHotelOrderPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    /**
     * 继修改订单的状态 -add by donghai
     * @param id
     * @return
     * @throws Exception
     */
    public boolean updateHotelOrderStatus(Long id) throws Exception;

    /**
     * 根据房间id和用户所需预定的开始日期和结束日期来查询所选择的房间的剩余可预定数量 -add by donghai
     * @param roomId
     * @param startDate
     * @param endDate
     * @return
     * @throws Exception
     */
    public int getRoomNumByRoomIdTypeAndDate(Integer roomId, String startDate, String endDate) throws Exception;

    /**
     * 根据订单的预定天数和房间的单价计算订单总金额 -add by donghai
     * @param count ,roomId count为天数和房间数量的乘积
     * @return
     * @throws Exception
     */
    public BigDecimal getOrderPayAmount(int count, Long roomId) throws Exception;

    public Page<ItripListHotelOrderVO> queryOrderPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;

    public boolean flushOrderStatus(Integer type)throws Exception;

    /**
     * 通过订单id查看订单详情-具体房型信息等- add by hanlu
     * @param orderId
     * @return
     * @throws Exception
     */
    public ItripPersonalOrderRoomVO getItripHotelOrderRoomInfoById(Long orderId)throws Exception;


}
