package cn.itrip.biz.service.hotel;
import cn.itrip.beans.pojo.ItripHotel;
import cn.itrip.beans.vo.hotel.HotelVideoDescVO;
import cn.itrip.beans.vo.hotel.ItripSearchDetailsHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchFacilitiesHotelVO;
import cn.itrip.beans.vo.hotel.ItripSearchPolicyHotelVO;
import cn.itrip.common.Page;

import java.util.List;
import java.util.Map;

/**
* Created by shang-pc on 2015/11/7.
*/
public interface ItripHotelService {

    /**
     * 根据酒店id查询酒店特色、商圈、酒店名称
     * @param id
     * @return
     * @throws Exception
     */
    public HotelVideoDescVO getVideoDescByHotelId(Long id)throws Exception;

    public ItripHotel getItripHotelById(Long id)throws Exception;

    /**
     * 根据酒店的id查询酒店的设施 -add by donghai
     * @param id
     * @return
     * @throws Exception
     */
    public ItripSearchFacilitiesHotelVO getItripHotelFacilitiesById(Long id)throws Exception;

    /**
     * 根据酒店的id查询酒店的政策 -add by donghai
     * @param id
     * @return
     * @throws Exception
     */
    public ItripSearchPolicyHotelVO queryHotelPolicy(Long id)throws Exception;

    /**
     * 根据酒店的id查询酒店的特色和介绍 -add by donghai
     * @param id
     * @return
     * @throws Exception
     */
    public List<ItripSearchDetailsHotelVO> queryHotelDetails(Long id)throws Exception;

    public List<ItripHotel>	getItripHotelListByMap(Map<String, Object> param)throws Exception;

    public Integer getItripHotelCountByMap(Map<String, Object> param)throws Exception;

    public Integer itriptxAddItripHotel(ItripHotel itripHotel)throws Exception;

    public Integer itriptxModifyItripHotel(ItripHotel itripHotel)throws Exception;

    public Integer itriptxDeleteItripHotelById(Long id)throws Exception;

    public Page<ItripHotel> queryItripHotelPageByMap(Map<String, Object> param, Integer pageNo, Integer pageSize)throws Exception;
}
