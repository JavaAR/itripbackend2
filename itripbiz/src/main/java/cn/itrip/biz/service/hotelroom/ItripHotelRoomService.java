package cn.itrip.biz.service.hotelroom;
import cn.itrip.beans.pojo.ItripHotelRoom;
import java.util.List;
import java.util.Map;

import cn.itrip.beans.vo.hotelroom.ItripHotelRoomVO;
import cn.itrip.common.Page;
/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelRoomService {

    public ItripHotelRoom getItripHotelRoomById(Long id)throws Exception;

    public List<ItripHotelRoomVO>	getItripHotelRoomListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelRoomCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception;

    public Integer itriptxModifyItripHotelRoom(ItripHotelRoom itripHotelRoom)throws Exception;

    public Integer itriptxDeleteItripHotelRoomById(Long id)throws Exception;

    public Page<ItripHotelRoomVO> queryItripHotelRoomPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
